package com.company;

public class _134GasStation {
    public static void main(String args[]){
        int[] gas = {4,5,2,6,5,3};
        int[] cost = {3,2,7,3,2,9};
        int res = canCompleteCircuit(gas, cost);
        System.out.println(res);
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i< gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                start = i + 1;
            }
            sum += gas[i] - cost[i];
        }
        if (sum < 0) {
            return -1;
        }
        return start;
    }
}
