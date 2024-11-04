package com.example.UnitTestExempel1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    //arrange
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    void testAddEndpoint() throws Exception{
        when(calculatorService.add(2,3)).thenReturn(5);


        mockMvc.perform(get("/calculator/add")
                .param("a","2").param("b","3"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("5"));

        verify(calculatorService).add(2,3);

    }

    @Test
    void subtract() throws Exception{
        when(calculatorService.subtract(4,3)).thenReturn(1);

        mockMvc.perform(get("/calculator/subtract")
                .param("a","4")
                .param("b","3"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("1"));

        verify(calculatorService).subtract(4,3);

    }

    @Test
    void testAddWithMapREsponse() throws Exception{
        when(calculatorService.add(2,3)).thenReturn(5);

        mockMvc.perform(get("/calculator/add2")
                        .param("a","2").param("b","3"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"result\": 5}"));

        verify(calculatorService).add(2,3);

    }
}