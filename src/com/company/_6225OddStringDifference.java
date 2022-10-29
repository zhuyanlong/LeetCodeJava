package com.company;

import java.util.Arrays;

public class _6225OddStringDifference {
    public static String oddString(String[] words) {
        int[][] res = new int[words.length][words[0].length()-1];
        int k = 0;
        for (String word : words) {
            int[] item = new int[word.length()-1];
            for (int i = 1; i < word.length(); i++) {
                item[i-1] = word.charAt(i) - word.charAt(i-1);
            }
            res[k++] = item;
        }
        int num = 0;
        for (int i = 1; i < res.length; i++) {
            if (!Arrays.equals(res[0], res[i])) {
                num = i;
                break;
            }
        }
        if (num == 1) {
            if (!Arrays.equals(res[0], res[num + 1])) {
                return words[0];
            }
        }
        return words[num];
    }
    public static void main(String[] args) {
        String[] words = new String[]{"aaa","bob","ccc","ddd"};
        String res = oddString(words);
        System.out.println(res);
        System.out.println();
    }
}
