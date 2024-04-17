package com.example.features.virtualthread;

import java.util.Random;

public class VirtualThreadGroup {
    public static void main(String[] args) {
        boolean vThreads = true;
        System.out.println( "Using vThreads: " + vThreads);

        long start = System.currentTimeMillis();

        Random random = new Random();
        Runnable runnable = () -> { double i = random.nextDouble(1000) % random.nextDouble(1000);  };

        Thread vThread = Thread.startVirtualThread(runnable);
        System.out.println("vThread is virtual: " + vThread.isVirtual());
        ThreadGroup virtualThreadGroup = vThread.getThreadGroup();
        System.out.println("virtualThreadGroup: " +virtualThreadGroup);

        Thread virtualThread = new Thread(virtualThreadGroup, () -> {
            System.out.println("Running task in a virtual thread: "
                    + Thread.currentThread().getName());
        });
        System.out.println("is virtual:" + virtualThread.isVirtual());

        virtualThread.start();


        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Run time: " + timeElapsed);





    }
}
