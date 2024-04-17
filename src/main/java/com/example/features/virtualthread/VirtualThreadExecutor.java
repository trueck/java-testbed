package com.example.features.virtualthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class VirtualThreadExecutor {
    public static void main(String[] args) {
        ThreadFactory virtualThreadFactory = Thread.ofVirtual().name("v thread", 1).factory();

        try (ExecutorService executor = Executors.newFixedThreadPool(8, virtualThreadFactory)) {

            for (int i = 0; i < 8; i++) {
                executor.submit(() -> {
                    System.out.println("Running task in a virtual thread: "
                            + Thread.currentThread().getName());
                });
            }

           // executor.shutdown();
        }
    }
}
