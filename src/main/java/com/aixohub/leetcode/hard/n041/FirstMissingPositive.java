package com.aixohub.leetcode.hard.n041;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * first-missing-positive
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int i = firstMissingPositive(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(i);

    }


    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 1. 置换排序：将每个数放到正确的位置 nums[i] == i + 1
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 2. 遍历数组，找到第一个 nums[i] != i + 1 的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 3. 如果所有位置都正确，则返回 n + 1
        return n + 1;
    }

    // 交换数组中的两个元素
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
