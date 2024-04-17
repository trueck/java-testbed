package com.example.leetcode;

public class ZFormat {

    public String convert(String s, int numRows) {
        char[] sArray = s.toCharArray();

        StringBuilder[] sbArray = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbArray[i] = new StringBuilder();
        }

        int index = 0;
        int oneRound = numRows + numRows - 2;
        if (numRows == 1) {
            return s;
        }
        if (oneRound == 0) {
            oneRound = 1;
        }
        if (s.length() == 1) {
            oneRound = 1;
        }
        int numRound = 1;

        numRound = s.length() / oneRound;
        if (s.length() % oneRound != 0) {
            numRound++;
        }

        for (int i = 0; i < numRound; i++) {
            for (int j = 0; j < oneRound; j++) {
                for (int k = 0; k < numRows; k++) {
                    if (index >= s.length()) {
                        break;
                    }
                    // System.out.println("setting index " + index);
                    sbArray[k].append(sArray[index]);
                    index++;
                }
                System.out.println(sbArray[0].toString());

                for (int k = numRows - 2; k > 0; k--) {
                    if (index >= s.length()) {
                        break;
                    }
                    //   System.out.println("setting index " + index);
                    sbArray[k].append(sArray[index]);
                    index++;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < numRows; k++) {
            result.append(sbArray[k].toString());
        }
        return result.toString();
    }
}