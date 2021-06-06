package com.aixohub.leetcode.simple.twoSumLessThanK;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和整数 k ，返回最大和 sum ，满足存在 i < j 使得 nums[i] + nums[j] = sum 且 sum < k 。如果没有满足此等式的 i,j 存在，则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [34,23,1,24,75,33,54,8], k = 60
 * 输出：58
 * 解释：
 * 34 和 24 相加得到 58，58 小于 60，满足题意。
 * 示例 2：
 *
 * 输入：nums = [10,20,30], k = 15
 * 输出：-1
 * 解释：
 * 我们无法找到和小于 15 的两个元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-less-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSumLessThanK01 {

    public static void main(String[] args) {
       int [] nums = {254,914,110,900,147,441,209,122,571,942,136,350,160,127,178,839,201,386,462,45,735,467,153,415,875,282,204,534,639,994,284,320,865,468,1,838,275,370,295,574,309,268,415,385,786,62,359,78,854,944};
       int k = 200;
        int i = twoSumLessThanK1(nums, k);
        System.out.println(i);


    }

    public static int twoSumLessThanK1(int[] nums, int k) {
        if(nums == null || nums.length < 2){
            return -1;
        }
        Arrays.sort(nums);
        int curSum = -1;
        int right = 0;
        int left = nums.length -1;
        while(right < left){
            if(nums[right] + nums[left] >= k){
                left--;
            }else{
                curSum = Math.max(nums[right]+nums[left], curSum);
                ++right;
            }
        }
        return curSum;
    }

}
