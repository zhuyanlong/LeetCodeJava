package com.company;

import java.util.HashMap;
import java.util.Map;

public class _6241NumberofUnequalTripletsinArray {
    public static int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (map.keySet().size() < 3) {
            return 0;
        }
        int[] keys = new int[map.size()];
        int count = 0;
        for (int key : map.keySet()) {
            keys[count++] = key;
        }
        int res = 0;
//        如何做组合，这段代码要记住，虽然复杂度很高，但是是比较容易理解的
        for (int i = 0; i < keys.length; i++) {
            for (int j = i + 1; j < keys.length; j++) {
                for (int k = j + 1 ; k < keys.length; k++) {
                    res += map.get(keys[i]) * map.get(keys[j]) * map.get(keys[k]);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4,4,2,4,3};
        int res = unequalTriplets(nums);
    }
}
