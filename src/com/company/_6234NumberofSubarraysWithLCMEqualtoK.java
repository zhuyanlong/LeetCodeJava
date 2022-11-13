package com.company;

public class _6234NumberofSubarraysWithLCMEqualtoK {
    public static int subarrayLCM(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int currLCM = nums[i];
            for (int j = i; j < n; j++) {
                currLCM = LCM(currLCM, nums[j]);
                res += (currLCM == k) ? 1 : 0;
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

    public static int LCM(int num, int divisor) {
        return num * divisor / GCD(num, divisor);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,1,1,2};
        int k = 1;
        int res = subarrayLCM(nums, k);
    }
}
