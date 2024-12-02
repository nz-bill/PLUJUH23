package com.example.SpringSecurityEx1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BasicController {


    //vi skapade denna endast för att Bill blev förvirrad när vi fick error 404 efter en lyckad inloggning i postman.
    //(efter lyckad inloggning så blir vi redirectade till "/")
    @GetMapping
    public String greeting(){
        return "welcome to the root!!";
    }
}
