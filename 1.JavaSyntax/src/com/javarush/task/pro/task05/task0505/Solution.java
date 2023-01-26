package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] store = new int[n];

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                store[i] = s.nextInt();
            }
        }

        if (n % 2 != 0) {
            for (int j = 0; j < n; j++) {
                System.out.println(store[j]);
            }
        } else {
            for (int k = n - 1; k >= 0; k--) {
                System.out.println(store[k]);
            }
        }
    }
}
