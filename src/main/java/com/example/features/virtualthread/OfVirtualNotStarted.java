package com.example.features.virtualthread;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

public class OfVirtualNotStarted {
    @SneakyThrows
    public static void main(String[] args) {
        final int numberOfThreads = 1000000;

        for (int i = 0; i < numberOfThreads; i++) {
            final int tIndex = i;
            Thread virtualThread = Thread.ofVirtual().unstarted(() -> {
                System.out.println("virtual thread "  + tIndex + " is running on " + Thread.currentThread().getName());
            });

            virtualThread.start();

           // String str = String.format("Java 21 virtual thread number %s is running.", i);

          //  System.out.println(str);

        }

       System.in.read();
    }
}
