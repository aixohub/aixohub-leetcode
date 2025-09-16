package com.aixohub.leetcode.hard.n440;

/**
 * <pre>
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 *
 * 示例 1:
 *
 * 输入: n = 13, k = 2
 * 输出: 10
 * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * 示例 2:
 *
 * 输入: n = 1, k = 1
 * 输出: 1
 * </pre>
 */
public class KthSmallestInLexicographicalOrder2 {

    public static void main(String[] args) {
        System.out.println(findKthNumber(13, 6));
        // System.out.println(findKthNumber(13, 4));
    }


    public static int findKthNumber(int n, long k) {
        int cur = 1;
        k--; // 因为第 1 个就是 1，我们要找第 k 个

        while (k > 0) {
            long steps = countSteps(n, cur, cur + 1);
            if (steps <= k) { // 目标不在当前前缀，跳过该前缀
                cur++;
                k -= steps;
            } else { // 目标在当前前缀内部，深入
                cur *= 10;
                k--;
            }
        }

        return cur;
    }

    // 计算以 `prefix` 开头的子树大小
    private static long countSteps(int n, long first, long last) {
        long steps = 0;
        while (first <= n) {
            steps += Math.min(last, n + 1) - first;
            first *= 10;
            last *= 10;
        }
        return steps;
    }


}
