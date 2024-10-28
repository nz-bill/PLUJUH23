package com.example.repoPattern1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product p = productRepository.findById(id).orElseThrow();
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        return productRepository.save(p);


    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
    }
}
