package com.javarush.task.pro.task05.task0508;

import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        strings = new String[6];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = s.nextLine();
        }

        for (int j = 0; j < strings.length; j++) {
            if (strings[j] == null) continue;

            String temp = new String(strings[j]);

            for (int k = j + 1; k < strings.length; k++) {
                if (temp.equalsIgnoreCase(strings[k])) {
                    strings[j] = null;
                    strings[k] = null;
                }
            }
        }

        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}
