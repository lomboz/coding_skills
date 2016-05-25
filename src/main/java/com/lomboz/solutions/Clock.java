/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lomboz.solutions;

public class Clock {

    public String calculate(int A, int B, int C, int D) {
        int[] input = new int[]{A, B, C, D}; // 1,8,3,2
        int[] target = new int[]{-1,-1,-1,-1};
        calculateDigit(input, target);

        return getFormattedTime(target);
    }

    private void calculateDigit(int[] input, int[] target) {
        int usedIndex = -1;
        int countOfDigits = 4;

        for (int x = 1; x <= countOfDigits; x++) {
            for (int i = 0; i < input.length; i++) {
                int digit = input[i];
                if (x == 1) {
                    if (digit > target[0] && digit <= 2) {
                        target[0] = input[i];
                        usedIndex = i;
                    }
                }
                if (x == 2) {
                    int highestAllowedDigit = 9;
                    if (target[0] == 2) {
                        highestAllowedDigit = 3;
                    }
                    if (digit > target[1] && digit <= highestAllowedDigit) {
                        target[1] = input[i];
                        usedIndex = i;
                    }
                }
                if (x == 3) {
                    int highestAllowedDigit = 5;
                    if (digit > target[2] && digit <= highestAllowedDigit) {
                        target[2] = input[i];
                        usedIndex = i;
                    }
                }
                if (x == 4) {
                    int highestAllowedDigit = 9;
                    if (digit > target[3] && digit <= highestAllowedDigit) {
                        target[3] = input[i];
                        usedIndex = i;
                    }
                }
            }
            input[usedIndex] = -1;
        }
    }

    private String getFormattedTime(int[] timevalues) {
        for (int i : timevalues) {
            if (i == -1) {
                return "NOT_POSSIBLE";
            }
        }
        String time = String.valueOf(timevalues[0]);
        time += String.valueOf(timevalues[1]);
        time += ":";
        time += String.valueOf(timevalues[2]);
        time += String.valueOf(timevalues[3]);
        return time;
    }

    public static void main(String[] args) {
        System.out.println("[1832] => " + new Clock().calculate(1, 8, 3, 2)); // Expect 23:18
        System.out.println("[2400] => " + new Clock().calculate(2, 4, 0, 0)); // Expect 20:40
        System.out.println("[9290] => " + new Clock().calculate(9, 2, 9, 0)); // Expect NOT POSSIBLE
    }
}
