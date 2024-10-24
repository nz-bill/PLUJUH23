package com.example.simpleRest;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

   private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id){
        Optional<Product> product = productService.getProductById(id);
        return product.orElse(null);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody @Valid Product newProduct){
        return productService.updateProduct(id, newProduct);


    }

    @PostMapping
    public Product createProduct(@RequestBody @Valid Product product){
       return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable long id){
       boolean isDeleted = productService.deleteProduct(id);

       if(isDeleted){
           return "product with id " + id +" is deleted";
       } else{
           return "product with id " +id + " not found";
       }
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){
//        Map<String,String> errors = new HashMap<>();
//        ex.getBindingResult()
//                .getFieldErrors()
//                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }


}
