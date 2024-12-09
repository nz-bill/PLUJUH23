package com.example.SpringSecurityEx1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


//commandLineRunner låter oss köra kod vid start av applikationen
@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;



    public DatabaseInitializer(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {


        //lägger till roller i databasen
        if(roleRepository.findByName("ROLE_USER") == null){
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
            System.out.println("added ROLE_USER to database");
        }

        if(roleRepository.findByName("ROLE_ADMIN") == null){
            Role userRole = new Role();
            userRole.setName("ROLE_ADMIN");
            roleRepository.save(userRole);
            System.out.println("added ROLE_ADMIN to database");
        }


        // lägger till en default admin i databasen
        if (userRepository.findByUsername("admin").isEmpty()){
            User admin = new User();
            admin.setUsername("admin");
            admin.getRoles().add(roleRepository.findByName("ROLE_ADMIN"));
            admin.setPassword(passwordEncoder.encode("pass123"));
            userRepository.save(admin);
        }



    }
}
