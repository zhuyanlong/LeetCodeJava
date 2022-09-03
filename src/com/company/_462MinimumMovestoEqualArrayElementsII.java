package com.company;

import java.util.Arrays;

public class _462MinimumMovestoEqualArrayElementsII {
    public static void main(String args[]){
        int [] nums= new int[]{1,2,3,4,5,6};
        int res=minMoves2(nums);
        System.out.println(res);
    }
    public static int minMoves2(int[] nums) {
        int res=0;
        Arrays.sort(nums);
        int midNums=0;
        if(nums.length%2==0){
            midNums=(nums[(nums.length-1)/2]+nums[nums.length/2])/2;
        }else{
            midNums=nums[nums.length/2];
        }
        for(int i=0;i<nums.length;i++){
            res+=Math.abs(nums[i]-midNums);
        }
        return res;
    }
}
