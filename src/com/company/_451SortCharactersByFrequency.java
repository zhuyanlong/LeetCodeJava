package com.company;

import java.util.*;

public class _451SortCharactersByFrequency {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        List<Map.Entry<Character, Integer>> listData = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
        Collections.sort(listData, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < listData.size(); j++) {
            for (int i = 0 ; i < listData.get(j).getValue(); i++) {
                res.append(listData.get(j).getKey());
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String s = "Aabb";
        String res = frequencySort(s);
    }
}
