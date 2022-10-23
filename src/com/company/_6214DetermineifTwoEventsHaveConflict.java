package com.company;

import java.util.HashSet;
import java.util.Set;

public class _6214DetermineifTwoEventsHaveConflict {
    public static boolean haveConflict(String[] event1, String[] event2) {
        Set<String> set = new HashSet<>();
        set.add(event1[0]);
        set.add(event1[1]);
        set.add(event2[0]);
        set.add(event2[1]);
        if (set.size() != 4) {
            return true;
        }
        if (event1[0].compareTo(event2[0]) < 0) {
            return event1[1].compareTo(event2[0]) > 0;
        }
        if (event2[0].compareTo(event1[0]) < 0) {
            return event2[1].compareTo(event1[0]) > 0;
        }
        return false;
    }
    public static void main(String[] args) {
        String[] event1 = new String[]{"01:15", "02:00"};
        String[] event2 = new String[]{"02:01", "03:00"};
        boolean res = haveConflict(event1, event2);
        System.out.println(res);
    }
}
