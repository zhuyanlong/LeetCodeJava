package com.company;

public class _168ExcelSheetColumnTitle {
    public static String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        int divNum = columnNumber;
        int restNum = 0;
        while (divNum != 0) {
            restNum = (divNum - 1) % 26;
            divNum = (divNum - 1) / 26;
            stringBuilder.append((char)(restNum + (int)'A'));
        }
        String res = stringBuilder.reverse().toString();
        return res;
    }
    public static void main(String[] args) {
        int columnNumber = 28;
        String res = convertToTitle(columnNumber);
        System.out.println(res);
    }
}
