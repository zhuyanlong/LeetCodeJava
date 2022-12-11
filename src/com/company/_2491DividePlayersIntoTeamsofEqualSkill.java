package com.company;

import java.util.Arrays;

public class _2491DividePlayersIntoTeamsofEqualSkill {
    public static long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long sum = (long) skill[0] * skill[skill.length - 1];
        int target = skill[0] + skill[skill.length - 1];
        for (int i = 1; i < skill.length / 2; i++) {
            int tmp = target - skill[i];
            if (tmp == skill[skill.length - i - 1]) {
                sum += (long) tmp * skill[i];
            } else {
                return -1;
            }
        }
        return sum;
    }

    public static boolean findValue(int[] skill, int value) {
        for(int i = 0; i < skill.length; i++) {
            if (skill[i] == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] skill = new int[]{1,1,2,3};
        long sum = dividePlayers(skill);
    }
}
