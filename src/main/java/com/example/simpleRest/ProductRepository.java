package com.example.simpleRest;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private List<Product> products = new ArrayList<>();


    public List<Product> findAll(){
        return products;
    }

    public Optional<Product> findByID(long id){
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }

    public Product updateProduct(Product product){
        findByID(product.getId()).ifPresent(p -> {
            p.setName(product.getName());
            p.setQuantity(product.getQuantity());
            p.setPrice(product.getPrice());
        });

        return product;
    }

    public Product saveProduct(Product product){
        product.setId((long) products.size() +1);
        products.add(product);
        return  product;
    }

    public void delete(long id){
        products.removeIf(p -> p.getId() == id);
    }
}
