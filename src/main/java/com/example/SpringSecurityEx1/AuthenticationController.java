package com.example.SpringSecurityEx1;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserService userService;
    private final JWTUtil jwtUtil;


    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;


    @Autowired
    public AuthenticationController(UserService userService, JWTUtil jwtUtil, AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }


    //en endpoint för att registrera nya användare
//    @PostMapping("/register")
//    public String register(@RequestParam String username,@RequestParam String password){
//        userService.registerUser(username,password);
//        return "user registered successfully";
//    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody UserAuthDTO user){


        userService.registerUser(user);

        return "user registered successfully";
    }





    @PostMapping("/login")
    public String login(@RequestBody UserAuthDTO userDto){

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDto.getUsername(),userDto.getPassword())
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getUsername());


            return jwtUtil.generateToken(userDetails.getUsername());
        } catch(AuthenticationException e){
            return "invalid credentials";
        }


    }
}
