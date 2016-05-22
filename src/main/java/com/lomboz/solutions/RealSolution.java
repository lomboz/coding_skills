/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lomboz.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author hansschneider
 */
public class RealSolution {

    public int solution1(int[] A) {
        // write your code in Java SE 8
        Map<Integer,Integer> helperMap = new HashMap<>();
        int maxValue = 0;
        
        for (int i : A) {
            helperMap.compute(i, (k, v)-> v == null ? 1 : v+1);
        }
        
        for (Entry<Integer, Integer> e: helperMap.entrySet()) {
            int tempValue = e.getValue() + helperMap.getOrDefault(e.getKey() +1, 0);
            if(tempValue > maxValue){
                maxValue = tempValue;
            }
        }
        return maxValue;
    }

    public String solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
        int[] inputDigits = new int[]{A, B, C, D};
        int[] time = new int[]{-1, -1, -1, -1};

        List usedIndex = new ArrayList();
        time[0] = findValueForPosition(inputDigits, 1, usedIndex);
        time[1] = findValueForPosition(inputDigits, 2, usedIndex);
        time[2] = findValueForPosition(inputDigits, 3, usedIndex);
        time[3] = findValueForPosition(inputDigits, 4, usedIndex);

        return getFormattedTime(time);
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

    private int findValueForPosition(int[] input, int pos, List usedIndex) {
        int highestPossibleValue = -1;
        int index = 0;
        switch (pos) {
            case 1:
                for (int i : input) {
                    if (i <= 2 && i > highestPossibleValue && !usedIndex.contains(index)) {
                        highestPossibleValue = i;
                        usedIndex.add(index);
                    }
                    index++;
                }
                break;
            case 2:
                for (int i : input) {
                    if (i > highestPossibleValue && i <= 4 && !usedIndex.contains(index)) {
                        highestPossibleValue = i;
                        usedIndex.add(index);
                    }
                    index++;

                }
                break;
            case 3:
                for (int i : input) {
                    if (i > highestPossibleValue && i <= 5 && !usedIndex.contains(index)) {
                        highestPossibleValue = i;
                        usedIndex.add(index);
                    }
                    index++;

                }
                break;
            case 4:
                for (int i : input) {
                    if (i > highestPossibleValue && i <= 9 && !usedIndex.contains(index)) {
                        highestPossibleValue = i;
                        usedIndex.add(index);
                    }
                    index++;

                }
                break;
        }
        return highestPossibleValue;
    }

    public static void main(String[] args) {
        System.out.println(new RealSolution().solution(1, 8, 3, 2));
        System.out.println(new RealSolution().solution(2, 4, 0, 0));
        
        System.out.println(new RealSolution().solution1(new int[]{6, 10, 6, 9, 7, 8}));
    }
}
