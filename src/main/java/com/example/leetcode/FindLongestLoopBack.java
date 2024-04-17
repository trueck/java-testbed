package com.example.leetcode;

public class FindLongestLoopBack {

    public String longestPalindrome(String s) {
        System.out.println("input length: " + s.length());
        String longestString = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j != i; j--) {

                if (continueCompare(s, i, j)) {
                    System.out.println("got result : " + i + " " + j);
                    if (j + 1 - i > longestString.length()) {
                        longestString = s.substring(i, j + 1);
                    }
                    break;
                }
            }
        }
        return longestString;
    }

    private boolean continueCompare(String s, int i, int j) {
        System.out.println("comparing " + i + " and " + j);
        if (i == 490) {
            System.out.println("hello");
        }
        if (i >= j) {
            return true;
        }
        if (s.charAt(i) == s.charAt(j)) {
            while (i < j) {
                if (!continueCompare(s, ++i, --j)) {
                    return false;
                } else {
                    break;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
