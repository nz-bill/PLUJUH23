package com.example.repoPattern1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Bean
    public CommandLineRunner loadData(){
        return args -> {
            Category coffee = new Category();
            coffee.setName("coffees");

            Category juice = new Category();
            juice.setName("juices");

            categoryRepository.save(coffee);
            categoryRepository.save(juice);


            Product regularCoffe = new Product();
            regularCoffe.setName("vanligt bryggkaffe");
            regularCoffe.setPrice(20);
            regularCoffe.setCategory(coffee);

            Product latte = new Product();
            latte.setName("kaffe latte");
            latte.setPrice(25);
            latte.setCategory(coffee);

            Product orangeJuice = new Product();
            orangeJuice.setName("apelsin juice");
            orangeJuice.setPrice(15);
            orangeJuice.setCategory(juice);

            productRepository.save(regularCoffe);
            productRepository.save(latte);
            productRepository.save(orangeJuice);
        };
    }
}
