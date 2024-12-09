package com.example.SpringSecurityEx1;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User registerUser(String userName, String rawPassword){
        User user = new User();
        Role role = roleRepository.findByName("ROLE_USER");

        user.setUsername(userName);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.getRoles().add(role);


        return userRepository.save(user);
    }

    public Optional<User> findUserNyName(String name){
        return userRepository.findByUsername(name);
    }
}
