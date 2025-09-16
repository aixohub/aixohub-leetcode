package com.aixohub.leetcode.medium.n137;

public class SingleNumber {


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 2, 3, 2, 3, 2, 3, 99};
        int q = singleNumbers(nums);
        System.out.println(q);
    }


    public static int singleNumbers(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & (~twos);
            twos = (twos ^ num) & (~ones);
        }

        // 最终，`ones` 保存的是只出现一次的数字
        // 因为出现三次的数字在 `ones` 和 `twos` 中都已经被抵消（清零）了
        return ones;
    }
}

