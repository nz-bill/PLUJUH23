package com.example.simpleRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepo;

    @Autowired
    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(long id){
        return productRepo.findByID(id);
    }

    public Product createProduct(Product product){
        return productRepo.saveProduct(product);
    }

    public Product updateProduct(long id, Product newProduct){
        Optional<Product> product = productRepo.findByID(id);

        if(product.isPresent()){
            newProduct.setId(id);
            return productRepo.updateProduct(newProduct);

        } else {
            return null;
        }

    }

    public boolean deleteProduct(long id){
        Optional<Product> product = productRepo.findByID(id);

        if(product.isPresent()){

            productRepo.delete(id);
            return  true;
        } else {
            return false;
        }
    }

}
