package com.aixohub.leetcode.medium.n045;

/**
 * <pre>
 *   给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 *   每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 *   0 <= j <= nums[i]
 *    i + j < n
 *    返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * </pre>
 */
public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int currentEnd = 0; // 当前能够到达的最远位置
        int farthest = 0;   // 在当前步数下，所有位置能够到达的最远位置

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                // 遇到当前步数能够到达的最远位置，更新当前步数，并且增加跳跃次数
                currentEnd = farthest;
                jumps++;
            }
        }

        return jumps;
    }

}
