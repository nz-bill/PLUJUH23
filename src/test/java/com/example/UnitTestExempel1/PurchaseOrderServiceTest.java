package com.example.UnitTestExempel1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class PurchaseOrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void createOrder() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(1L);

        when(orderRepository.save(purchaseOrder)).thenReturn(purchaseOrder);

        PurchaseOrder result = orderService.createOrder(purchaseOrder);

        assertEquals(1L,result.getId());

        verify(orderRepository).save(purchaseOrder);

    }

    @Test
    void findOrderById() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(1L);

        when(orderRepository.findById(1L)).thenReturn(Optional.of(purchaseOrder));

        PurchaseOrder result = orderService.findOrderById(1L).orElse(null);
        assertEquals(1L, result.getId());
        verify(orderRepository).findById(1L);
    }
}