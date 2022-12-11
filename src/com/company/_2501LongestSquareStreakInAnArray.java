package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class _2501LongestSquareStreakInAnArray {
    public static int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int tmp = nums[i];
            while (true) {
                if (set.contains(tmp * tmp)) {
                    count += 1;
                    tmp =tmp * tmp;
                } else {
                    break;
                }
            }
            if (count > res) {
                res = count;
            }
        }
        if (res == 0) {
            return -1;
        }
        return res + 1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,5,6,7,4};
        int res = longestSquareStreak(nums);
    }
}
