package com.javarush.task.pro.task04.task0418;

import java.util.Scanner;

/* 
Стакан наполовину пуст или наполовину полон?
*/

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        double glass = 0.5;
        boolean input = s.nextBoolean();
        
        if (input == false) System.out.println((int)Math.floor(glass));
        if (input == true) System.out.println((int)Math.ceil(glass)); 
    }
}