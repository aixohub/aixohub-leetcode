package com.aixohub.leetcode.simple.n448;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // 通过索引标记数字是否出现过
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // 数值对应的索引
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // 标记为负数
            }
        }

        // 找到未标记为负数的索引
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // 缺失数字为索引 + 1
            }
        }

        return result;
    }

    public static void main(String[] args) {


        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums1)); // 输出: [5, 6]

        int[] nums2 = {1, 1};
        System.out.println(findDisappearedNumbers(nums2)); // 输出: [2]
    }
}
