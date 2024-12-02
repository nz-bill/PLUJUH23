package com.example.SpringSecurityEx1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())       //vi disablar csrf för att kunna använda h2-consolen
        .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()  //vi vill kunna använda h2-conolen utan att logga in
                .requestMatchers("/auth/register").permitAll()  //vi behöver inte vara inloggade för att registrera oss
                .anyRequest().authenticated())

                //h2-console använder frames så vi behöver först tillåta det för att kunna se nåt i h2-console
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .formLogin(Customizer.withDefaults())       //vi använder standard inställningar för /login endpoint
                .logout(Customizer.withDefaults());         //vi använder standard inställningar för /logout endpoint

        return http.build();
    }

    //Denna metod används inte i denna version då vi istället  skapar vår egen CustomUserDetailsService Klass
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
//
//
//        //skapa användare
//        UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder.encode("user123"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("admin123"))
//                .roles("ADMIN")
//                .build();
//
//        // Returnera en InMemoryUserDetailsManager med användarna
//        return new InMemoryUserDetailsManager(user,admin);
//    }


    //vi måste använda en PasswordEncoder för att kunna skriva in lösenord i /login
    @Bean
    public PasswordEncoder passwordEncoder(){
        // BCrypt används för att kryptera lösenord
        return new BCryptPasswordEncoder();
    }


}
