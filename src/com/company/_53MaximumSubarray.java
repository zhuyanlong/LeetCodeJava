package com.company;

//面试的时候做到了这道题，最基础的动态规划问题
public class _53MaximumSubarray {
    public static void main(String args[]){
        int[] nums={5,4,-1,7,8};
        maxSubArray(nums);
    }
    public static int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int maxnum=nums[0];
        for(int i=1;i<dp.length;i++){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            if(dp[i]>maxnum){
                maxnum=dp[i];
            }
        }
//        System.out.println(maxnum);
        return maxnum;
    }
}
