package com.company;

public class _125ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length();
        while(i != j) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= '0' && s.charAt(i) <= '9') {

            } else {
                i++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = s = "A man, a plan, a canal: Panama";
        isPalindrome(s);
    }
}
