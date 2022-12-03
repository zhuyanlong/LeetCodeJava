package com.company;

public class _6249MinimumCutstoDivideaCircle {
    public static int numberOfCuts(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return n;
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int res = numberOfCuts(n);
    }
}
