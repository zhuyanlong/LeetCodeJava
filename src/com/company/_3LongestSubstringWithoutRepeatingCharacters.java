package com.company;

public class _3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]){
        String s=" ";
        _3Solution sol=new _3Solution();
        sol.lengthOfLongestSubstring(s);
    }
}

class _3Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlength=0;
        if(s.length()!=0){
            maxlength=1;
        }
        int i=0;
        for(int j=1;j<s.length();j++){
            for(int k=i;k<j;k++){
                if(s.charAt(k)==s.charAt(j)){
                    i=k+1;
                }
            }
            if(j-i+1>maxlength){
                maxlength=j-i+1;
            }
        }
        return maxlength;
    }
}
