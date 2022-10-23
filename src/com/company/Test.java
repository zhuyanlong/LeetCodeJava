package com.company;

public class Test {
    public static void main(String[] args) {
        char alpha = 'A';
        int foo = 65;
        boolean trueExp = true;
        System.out.println(trueExp ? alpha : 0);
        System.out.println(trueExp ? alpha : foo);
        System.out.println(trueExp ? alpha : 0);
        System.out.println(trueExp ? alpha : foo);
    }
}