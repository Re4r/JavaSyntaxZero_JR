package com.javarush.task.pro.task08.task0803;

import java.util.Scanner;

/* 
Минимальный элемент массива
*/

public class Solution {

    public static void main(String[] args) {
        int[] intArray = getArrayOfTenElements();
        System.out.println(min(intArray));
    }

    public static int min(int[] ints) {
        int minValue = ints[0];
        for (int x : ints) {
            if (Math.min(minValue, x) == x) {
                minValue = x;
            }
        }
        return minValue;
    }

    public static int[] getArrayOfTenElements() {
        int[] array = new int[10];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = s.nextInt();
        }
        return array;
    }
}
