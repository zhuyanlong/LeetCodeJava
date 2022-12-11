package com.company;

import java.util.ArrayList;
import java.util.List;

public class _207CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] G = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        List<Integer> bfs = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            G[i] = new ArrayList<Integer>();
        }
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                bfs.add(i);
            }
        }
        for (int i = 0; i < bfs.size(); i++) {
            for (int j : G[bfs.get(i)]) {
                if (--degree[j] == 0) {
                    bfs.add(j);
                }
            }
        }
        return bfs.size() == numCourses;
    }
    public static void main(String[] args) {
        int num = 2;
        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};
        boolean res = canFinish(num, prerequisites);
    }
}
