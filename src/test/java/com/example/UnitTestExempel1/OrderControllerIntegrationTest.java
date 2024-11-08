package com.example.UnitTestExempel1;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class OrderControllerIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {

    }


    /*
            { "customer":
                { "name": "bill", "age": 43},
              "orders": 23 }
     */

    /*
            [
                "obj1":{ "name": "name1"},
                "obj2":{ "name": "name2"}
            ]
     */
    @Test
    void createOrder() throws Exception {
        String jsonOrder = "{\"description\": \"new order\", \"amount\": 100.0 }";

        mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonOrder))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("new order"))
                .andExpect(jsonPath("$.amount").value(100.0));

    }

    @Test
    void getOrderById() throws  Exception{
        PurchaseOrder order = new PurchaseOrder();
        order.setAmount(100.0);
        order.setDescription("Test order");
        order = orderRepository.save(order);

        mockMvc.perform(get("/orders/" + order.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Test order"))
                .andExpect(jsonPath("$.amount").value(100.0));


    }

    @Test
    void getAllOrders() throws Exception{
        PurchaseOrder order = new PurchaseOrder();
        order.setAmount(100.0);
        order.setDescription("Test order");
        orderRepository.save(order);

        PurchaseOrder order2 = new PurchaseOrder();
        order2.setAmount(100.0);
        order2.setDescription("Test order");
        orderRepository.save(order2);

        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void deleteOrder() throws Exception{
        PurchaseOrder order = new PurchaseOrder();
        order.setAmount(100.0);
        order.setDescription("Test order");
        order = orderRepository.save(order);

        mockMvc.perform(delete("/orders/" + order.getId()))
                .andExpect(status().isOk());

        mockMvc.perform(get("/orders/" + order.getId()))
                .andExpect(status().isNotFound());
    }
}