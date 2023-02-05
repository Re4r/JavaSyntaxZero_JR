package com.javarush.task.pro.task09.task0917;

/* 
String pool
*/

public class Solution {
    public static void main(String[] args) {
        String first = new String("JavaRush");
        String second = new String("JavaRush");
        String third = new String("javarush");
        System.out.println(equal(first, second));
        System.out.println(equal(second, third));
    }

    public static boolean equal(String first, String second) {

        String sp1 = first.intern();
        String sp2 = second.intern();

        if (sp1 == sp2) {
            return true;
        } else {
            return false;
        }
    }
}
