/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lomboz.solutions;

import java.util.HashMap;
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
    
    public static void main(String[] args) {
        System.out.println(new RealSolution().solution1(new int[]{6, 10, 6, 9, 7, 8}));
    }
}
