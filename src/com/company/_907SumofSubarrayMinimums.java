package com.company;

import java.util.Stack;

public class _907SumofSubarrayMinimums {
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int M = 1000000007;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            dp[i + 1] = (dp[stack.peek() + 1] + (i - stack.peek()) * arr[i]) % M;
            stack.push(i);
            res = (res + dp[i + 1]) % M;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,4};
        int res = sumSubarrayMins(arr);
    }
}
