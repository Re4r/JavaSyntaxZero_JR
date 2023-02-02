package com.javarush.task.pro.task08.task0801;

import static java.lang.Math.toRadians;

/* 
Утильный класс: часть 1
*/

public class Solution {

    public static double sin(double a) {
        double x = Math.sin(Math.toRadians(a));
        return x;
    }

    public static double cos(double a) {
        double y = Math.cos(Math.toRadians(a));
        return y;
    }

    public static double tan(double a) {
        double z = Math.tan(Math.toRadians(a));
        return z;
    }
}
