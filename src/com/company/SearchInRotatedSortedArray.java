package com.company;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] >= nums[i] ) {
                if (target >= nums[i] && target <= nums[m]) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            } else {
                if (target >= nums[m] && target <= nums[j]) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,8,0,1,2};
        int target = 7;
        int res = search(nums, target);
    }
}
