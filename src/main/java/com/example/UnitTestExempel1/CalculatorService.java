package com.example.UnitTestExempel1;

import org.springframework.stereotype.Service;


@Service
public class CalculatorService {

    private int counter = 0;
    public int add(int a, int b){
        return a+b;
    }

    public int subtract(int a, int b){
        this.counter++;
        return a - b;
    }

    public int getCounter() {
        return counter;
    }
}
