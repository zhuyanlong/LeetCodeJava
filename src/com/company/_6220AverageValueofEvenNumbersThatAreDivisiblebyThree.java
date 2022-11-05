package com.company;

public class _6220AverageValueofEvenNumbersThatAreDivisiblebyThree {
    public static int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 3 == 0 && num % 2 ==0) {
                sum += num;
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return sum / count;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,7,10};
        System.out.println(averageValue(nums));
    }
}
