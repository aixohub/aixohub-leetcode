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
public class KthSmallestInLexicographicalOrder {

    public static void main(String[] args) {
        System.out.println(findKthNumber(13, 2));
    }

    public static int findKthNumber(int n, int k) {
        int curr = 1;

        while (k > 1) {
            int count = getCount(curr, n);
            if (count < k) {
                curr++;
                k -= count;
            } else {
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    private static int getCount(int prefix, int n) {
        int count = 0;
        long curr = prefix;
        long next = prefix + 1;

        while (curr <= n) {
            count += Math.min(next, n + 1) - curr;
            curr *= 10;
            next *= 10;
        }

        return count;
    }
}
