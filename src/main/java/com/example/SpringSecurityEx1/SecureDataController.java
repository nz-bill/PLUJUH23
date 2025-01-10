package com.example.SpringSecurityEx1;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secure")
public class SecureDataController {

    private  final SecureDataService service;

    public SecureDataController(SecureDataService service) {
        this.service = service;
    }


    @PostMapping
    public SecureData saveData(@RequestBody String value){
        return service.saveData(value);
    }

    @GetMapping
    public List<SecureData> gaetAllData(){
        return  service.getAllData();
    }
}
