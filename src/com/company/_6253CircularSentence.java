package com.company;

public class _6253CircularSentence {
    public static boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        String tmp;
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                tmp = words[0];
            } else {
                tmp = words[i + 1];
            }
            if (words[i].charAt(words[i].length() - 1) != tmp.charAt(0) ) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String sentence = "eetcodd";
        boolean res = isCircularSentence(sentence);
    }
}
