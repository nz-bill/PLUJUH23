package com.example.UnitTestExempel1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private  OrderService orderService;

    @PostMapping
    public PurchaseOrder createOrder(@RequestBody PurchaseOrder purchaseOrder){
        return orderService.createOrder(purchaseOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getOrderById(@PathVariable Long id){
        Optional<PurchaseOrder> order = orderService.findOrderById(id);

        return order.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<PurchaseOrder> getAllOrders(){
        return orderService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
        if (orderService.deleteOrderById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
