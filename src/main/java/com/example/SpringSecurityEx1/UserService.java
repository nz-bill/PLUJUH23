package com.example.SpringSecurityEx1;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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


    public User registerUser(UserAuthDTO userDto){
        User user = new User();
        Role role = roleRepository.findByName("ROLE_USER");

        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.getRoles().add(role);


        return userRepository.save(user);
    }

    public List<UserDto> getAllUses(){
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> userList = userRepository.findAll();

        userList.forEach(user ->{
            Long id = user.getId();
            String username = user.getUsername();
            Set<Role> roles = user.getRoles();
            userDtoList.add(new UserDto(id, username, roles));
        });

        return userDtoList;
    }

    public Optional<User> findUserNyName(String name){
        return userRepository.findByUsername(name);
    }
}
