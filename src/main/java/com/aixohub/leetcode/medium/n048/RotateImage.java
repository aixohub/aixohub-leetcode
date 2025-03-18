package com.aixohub.leetcode.medium.n048;

import java.util.Arrays;

public class RotateImage {

    /**
     * 1
     * @param matrix 1
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // 遍历层数（每次旋转一圈）
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                // 进行四角旋转
                int temp = matrix[i][j]; // 左上
                int temp1 = matrix[n - 1 - j][i]; // 左下
                int temp2 = matrix[n - 1 - i][n - 1 - j]; //  右下
                int temp3 = matrix[j][n - 1 - i]; // 右上
                System.out.println(" temp : " + temp + " temp1 : " + temp1 + " temp2 : " + temp2 + " temp3 : " + temp3);
                matrix[i][j] = matrix[n - 1 - j][i]; // 左下 → 左上
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; // 右下 → 左下
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]; // 右上 → 右下
                matrix[j][n - 1 - i] = temp; // 左上 → 右上
            }
        }
    }

    /**
     * 2
     * @param matrix 2
     */
    public static void rotateSolution2(int[][] matrix) {
        int n = matrix.length;

        // 1. 先转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // 避免重复交换
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. 再水平翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) { // 对称交换
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);

        /*
         * [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
         */
        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }
}
