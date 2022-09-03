package com.company;

import java.util.Arrays;

public class _1647MinimumDeletionstoMakeCharacterFrequenciesUnique {
    public static void main(String args[]){
        String s="ceabaacb";
        int res=minDeletions(s);
        System.out.println(res);
    }

    public static int minDeletions(String s) {
        int res=0;
        int[] nums=new int[26];
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            nums[index]+=1;
        }
        Arrays.sort(nums);
        int exp=nums[25];
        for(int i=25;i>=0;i--){
            if(nums[i]==0){
                break;
            }
            if(exp>=nums[i]){
                exp=nums[i];
            }else{
                res+=nums[i]-exp;
            }
            if(exp>0){
                exp-=1;
            }
        }
        return res;
    }
}
