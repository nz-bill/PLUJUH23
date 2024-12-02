package com.example.SpringSecurityEx1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserService userService;


    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }


    //en endpoint för att registrera nya användare
    @PostMapping("/register")
    public String register(@RequestParam String username,@RequestParam String password){
        userService.registerUser(username,password);
        return "user registered successfully";
    }
}
