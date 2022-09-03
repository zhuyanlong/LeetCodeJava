package com.company;

import java.util.Arrays;

public class _453MinimumMovestoEqualArrayElements {
    public static void main(String args[]){
        int []nums=new int[]{1,2,3,4,5,6};
        int res=minMoves(nums);
        System.out.println(res);
    }
    public static int minMoves(int[] nums) {
        int res=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            res+=Math.abs(nums[i]-nums[nums.length-1]);
        }
        return res;
    }
}
