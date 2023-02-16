package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Ivan Ivan", 3.4);
        grades.put("Ivan Twowan", 4.5);
        grades.put("Ret OPert", 7.4);
        grades.put("qqq Jyrt", 4.8);
        grades.put("tyuiop ewwrqt", 6.9);
    }
}
