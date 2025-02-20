package com.coffeeshop.menu;

import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

@Component
public class CleanupBean {

    @PreDestroy
    public void onShutdown() {
        System.out.println("Shutting down the server and freeing port...");
        // Add code to clean up resources and close connections if needed
    }
}
