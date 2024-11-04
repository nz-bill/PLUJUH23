package com.example.UnitTestExempel1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b){
        return calculatorService.add(a,b);
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int a, @RequestParam int b){
        return calculatorService.subtract(a,b);
    }

    @GetMapping("/add2")
    public Map<String, Integer> add2(@RequestParam int a, @RequestParam int b){
        int result = calculatorService.add(a,b);
        Map<String, Integer> response = new HashMap<>();
        response.put("result", result);
        return response;

    }
}
