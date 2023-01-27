package com.javarush.task.pro.task05.task0516;

import java.util.Arrays;

/* 
Заполняем массив
*/

public class Solution {

    public static int[] array = new int[21];
    public static int valueStart = 10;
    public static int valueEnd = 13;

    public static void main(String[] args) {

        if (array.length % 2 == 0) {
            Arrays.fill(array, 0, array.length / 2, valueStart);
            Arrays.fill(array, array.length / 2, array.length, valueEnd);
        } else {
            double middleD = Math.ceil(array.length / 2.0);
            int middleI = (int)middleD;

            Arrays.fill(array, 0, middleI, valueStart);
            Arrays.fill(array, middleI, array.length, valueEnd);
        }

        System.out.println(Arrays.toString(array));
    }
}
