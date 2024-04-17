package com.example.features.virtualthread;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestVirtualThread {
    public static void main(String[] args) {
        Thread th = new Thread(() -> System.out.println("test"));
        th.start();

        ExecutorService single = Executors.newSingleThreadExecutor();
        single.submit(() -> System.out.println("exe1"));
        single.submit(() -> System.out.println("exe2"));
        single.shutdown();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < 10; i++) {
                executor.submit(() -> {
                    System.out.println("任务" + Thread.currentThread().getName() + "开始执行");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("任务" + Thread.currentThread().getName() + "执行完成");
                });
            }
        }


        boolean vThreads = true;
        System.out.println( "Using vThreads: " + vThreads);

        long start = System.currentTimeMillis();

        Random random = new Random();
        Runnable runnable = () -> { double i = random.nextDouble(1000) % random.nextDouble(1000);  };
        for (int i = 0; i < 50000; i++){
            if (vThreads){
                Thread.startVirtualThread(runnable);
            } else {
                Thread t = new Thread(runnable);
                t.start();
            }
        }

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Run time: " + timeElapsed);



        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> "Virtual Thread")
                .thenApplyAsync(result -> result.toUpperCase())
                .thenAcceptAsync(uppercaseResult -> {
                    System.out.println("Uppercase result: " + uppercaseResult +
                            " in thread: " + Thread.currentThread().getName());
                });

        future.join();

    }
}
