package com.example.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZFormatTest {
    @Test
    void testSolution(){
        String result = new ZFormat().convert("AB", 2);
        System.out.println(result);
        assertEquals("", result);
    }
}
