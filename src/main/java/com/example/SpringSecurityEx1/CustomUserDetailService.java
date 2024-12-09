package com.example.SpringSecurityEx1;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


//klass som gör om en User till en Userdetails. UserDetails används för att hantera inloggade användare
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //metod som returnerar en userdetails baserat på ett användarnamn
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //hämtar ett user object baserat på username
        User user= userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));

        //skapar och returnerar ett userDetails objekt baserat på ett User objekt hämtat från databasen
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role ->       //lägger till roller/authorities
                        new SimpleGrantedAuthority(role.getName())).toList());
    }
}
