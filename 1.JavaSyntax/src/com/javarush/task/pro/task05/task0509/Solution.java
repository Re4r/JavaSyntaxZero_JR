package com.javarush.task.pro.task05.task0509;

/* 
Таблица умножения
*/

public class Solution {

    public static int[][] MULTIPLICATION_TABLE;

    public static void main(String[] args) {
        MULTIPLICATION_TABLE = new int[10][10];



        for (int[] item : MULTIPLICATION_TABLE) {
            for (int i = 0; i < item.length; i++) {
                System.out.print(item[i] + " ");
            }
            System.out.println();
        }

    }
}
