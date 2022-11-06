package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

//    滑动窗口，这题的关键在于不能使用字典，要使用hashmap，将为空的键直接删除
    public static long maximumSubarraySumAns(int[] nums, int k) {
        long ans = 0;
        long sum = 0;
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            if (mp.containsKey(nums[i])) {
                mp.replace(nums[i], mp.get(nums[i]) + 1);
            } else {
                mp.put(nums[i], 1);
            }
            sum += nums[i];
            if(i >= k){
                mp.replace(nums[i - k], mp.get(nums[i - k]) - 1);
                sum -= nums[i - k];
                if (mp.get(nums[i - k]) == 0) {
                    mp.remove(nums[i - k]);
                }
            }
            if(mp.size() == k){
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,10,13,11,19,17,5,14,4,9};
        int k = 4;
        maximumSubarraySumAns(nums, k);
    }
}
