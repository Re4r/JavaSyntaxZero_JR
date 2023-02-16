package com.javarush.task.pro.task13.task1316;

public class Solution {

    public static void main(String[] args) {
        for (Enum item : JavarushQuest.values()) {
            System.out.println(item.ordinal());
        }
    }
}
