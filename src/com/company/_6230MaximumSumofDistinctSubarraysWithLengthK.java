package com.company;

import java.util.HashSet;

//这种做法是对的，但是时间复杂度过高
public class _6230MaximumSumofDistinctSubarraysWithLengthK {
    public static long maximumSubarraySum(int[] nums, int k) {
        int start = -1;
        int end = start + k;
        long sum = 0;
        while (end != nums.length) {
            start++;
            end++;
            HashSet<Integer> subSet = new HashSet<>();
            for (int i = start; i < end; i++) {
                subSet.add(nums[i]);
            }
            if (subSet.size() != k) {
                continue;
            } else {
                long tmp = 0;
                for (int j = start; j < end; j++) {
                    tmp += nums[j];
                }
                if (tmp > sum) {
                    sum = tmp;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,4,2,9,9,9};
        int k = 3;
        maximumSubarraySum(nums, k);
    }
}
