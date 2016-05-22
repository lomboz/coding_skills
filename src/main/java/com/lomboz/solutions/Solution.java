/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lomboz.solutions;

/**
 *
 * @author hansschneider
 */
public class Solution {

    public int[] solution_lession2(int[] A, int K) {
        System.out.println();
        for (int i : A) {
            System.out.print(i);
        }
        System.out.println();
        int[] shiftedArray = new int[A.length];
        int temp;
        for (int x = 0; x < K; x++) {
            int last = A[A.length -1];
            for(int i = A.length-2; i >= 0; i--){
                A[i+1] = A[i];
            }
            A[0] = last;
        }
        System.out.println("->");
        for (int i : A) {

            System.out.print(i);

        }
        return shiftedArray;
    }

    public int solution_lesson1(int N) {
        String binaryString = Integer.toBinaryString(N);
//        System.out.println(binaryString);
        char[] chars = binaryString.toCharArray();
        int longestGap = 0;
        int countOfLastGap = 0;
        for (char c : chars) {
            if (c == '0') {
                countOfLastGap++;
            }
            if (c == '1') {
                if (longestGap < countOfLastGap) {
                    longestGap = countOfLastGap;
                }
                countOfLastGap = 0;
            }
        }

        return longestGap;
    }

    public static void main(String[] args) {
        int result = new Solution().solution_lesson1(561892);
//        System.out.print("Ergebnis: " + result);

        int[] test = {3, 8, 9, 7, 6};
        int times = 3;
//        int[] result_lesson2 = new Solution().solution_lession2(test, times);
        int[] result_lesson2_1 = new Solution().solution_lession2(test, 99);
    }
}
