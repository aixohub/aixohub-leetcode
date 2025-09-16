package com.aixohub.leetcode.medium.n200;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {
//        char[][] grid = {{'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};
//
//        System.out.println(numIslands(grid));

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid2));

    }


    public static int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0) {
            return count;
        }
        int rows = grid.length, cols = grid[0].length;
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0';

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        for (int[] d : direction) {
                            int x1 = x + d[0];
                            int y1 = y + d[1];
                            if (x1 >= 0 && x1 < rows && y1 >= 0 && y1 < cols && grid[x1][y1] == '1') {
                                queue.offer(new int[]{x1, y1});
                                grid[x1][y1] = '0';
                            }

                        }
                    }
                }
            }

        }


        return count;
    }
}
