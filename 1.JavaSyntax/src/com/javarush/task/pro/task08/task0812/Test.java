package com.javarush.task.pro.task08.task0812;

public class Test {
    public static void main(String[] args) {
        byte octet = 5;
        String bin = String.format("%8s", Integer.toBinaryString(octet)).replace(' ', '0');
        System.out.println(bin);
    }
}
