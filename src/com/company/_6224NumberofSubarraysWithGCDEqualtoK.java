package com.company;

public class _6224NumberofSubarraysWithGCDEqualtoK {
    public static int subarrayGCD(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int currGCD = 0;
            for (int j = i; j < n; j++) {
                currGCD = GCD(currGCD, nums[j]);
                res += (currGCD == k) ? 1 : 0;
            }
        }
        return res;
    }
    public static int GCD(int num, int divisor) {
        int res = num % divisor;
        while (res != 0) {
            num = divisor;
            divisor = res;
            res = num % divisor;
        }
        return divisor;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{27, 9, 6, 81};
        int k = 3;
        int res = subarrayGCD(nums, k);
        System.out.println(res);
    }
}
