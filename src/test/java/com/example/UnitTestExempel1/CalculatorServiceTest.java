package com.example.UnitTestExempel1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    //Arrange
    private  CalculatorService calculattorService = new CalculatorService();

    @BeforeEach
    void setUp() {
        calculattorService = new CalculatorService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {


        //act
        int result = calculattorService.add(-100_000,100_000);

        //assert
        assertEquals(0,result);

    }

    @Test
    void subtract() {
        //act
        int result = calculattorService.subtract(4,3);


        //assert
        assertEquals(1,result);


    }

    @Test
    void counterValueFromSubtractTest(){
        calculattorService.subtract(3,3);
        calculattorService.subtract(4,3);

        assertEquals(2, calculattorService.getCounter());
    }
}