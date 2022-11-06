package com.company;

public class _6229ApplyOperationstoanArray {
    public static int[] applyOperations(int[] nums) {
        for (int i = 0; i< nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }
        int indexNum = 0;
        int indexZero = 0;
        while (indexNum != nums.length && indexZero != nums.length) {
            if (nums[indexZero] != 0) {
                indexZero++;
                indexNum = indexZero + 1;
            } else if (nums[indexNum] != 0) {
                int tmp = nums[indexNum];
                nums[indexNum] = nums[indexZero];
                nums[indexZero] = tmp;
            } else {
                indexNum++;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{0,1};
        applyOperations(nums);
    }
}
