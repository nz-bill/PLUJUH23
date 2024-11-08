package com.example.UnitTestExempel1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public PurchaseOrder createOrder(PurchaseOrder purchaseOrder){
        return orderRepository.save(purchaseOrder);
    }

    public List<PurchaseOrder> findAll(){
        return orderRepository.findAll();
    }

    public boolean deleteOrderById(Long id){

        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
            return  true;
        }
        return false;

    }

    public Optional<PurchaseOrder> findOrderById(Long id){

        return orderRepository.findById(id);
    }
}
