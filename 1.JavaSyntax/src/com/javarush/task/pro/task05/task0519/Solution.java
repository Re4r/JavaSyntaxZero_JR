package com.javarush.task.pro.task05.task0519;

import java.util.Arrays;

public class Solution {

    public static int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static int element = 5;

    public static void main(String[] args) {
        Arrays.sort(array);
        int index = Arrays.binarySearch(array, element);

        if (index != -1) {
            System.out.println(true);
        } else {
            System.out.print(false);
        }
    }
}
