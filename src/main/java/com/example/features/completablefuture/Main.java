package com.example.features.completablefuture;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static int compute(int n){
        return n * 2;
    }

    public static CompletableFuture<Integer> create(int n){
        return CompletableFuture.supplyAsync(() -> compute(n));
    }

    public static void main(String[] args) {
        create(4)
                .thenApply(e -> e + 1)
                .thenAccept(System.out::println
                );
    }
}
