package com.example.features.virtualthread;

import lombok.SneakyThrows;

public class OfVirtualNotStarted {
    @SneakyThrows
    public static void main() {
        final int numberOfThreads = 1000000;

        for (int i = 0; i < numberOfThreads; i++) {
            final int tIndex = i;
            Thread virtualThread = Thread.ofVirtual().unstarted(() -> {
                System.out.println(STR."virtual thread \{tIndex} is running on \{Thread.currentThread()}");
            });

            virtualThread.start();

           // String str = String.format("Java 21 virtual thread number %s is running.", i);

          //  System.out.println(str);

        }

       Thread.sleep(60000);
    }
}
