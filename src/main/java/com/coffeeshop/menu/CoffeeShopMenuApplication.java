package com.coffeeshop.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.coffeeshop.menu.model.Product;

@SpringBootApplication
public class CoffeeShopMenuApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CoffeeShopMenuApplication.class, args);

        // Product instantiation and printing details
        Product espresso = new Product((long)1, "Espresso", 2.99);
        Product croissant = new Product((long)2, "Croissant", 3.49);
    
        System.out.println("Product ID: " + espresso.getId() + " Product Name: " + espresso.getName() + " Product Price: " + espresso.getPrice());
        System.out.println("Product ID: " + croissant.getId() + " Product Name: " + croissant.getName() + " Product Price: " + croissant.getPrice());
       /* 
        // Clean shutdown
        int exitCode = SpringApplication.exit(context, () -> 0);
        System.exit(exitCode);
    */
    }
}
