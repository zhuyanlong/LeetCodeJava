package com.company;

import java.util.Arrays;

public class _6257DeleteGreatestValueInEachRow {
    public static int deleteGreatestValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        int sum = 0;
        for (int j = grid[0].length - 1; j >= 0; j--) {
            int maxVal = grid[0][0];
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] > maxVal) {
                    maxVal = grid[i][j];
                }
            }
            sum += maxVal;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] grid = new int[][]{{10}};
        deleteGreatestValue(grid);
    }
}
