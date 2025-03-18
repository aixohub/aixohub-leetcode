package com.aixohub.leetcode.medium.n560;

import java.util.HashMap;

public class SubArraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 处理刚好 prefixSum == k 的情况

        for (int num : nums) {
            prefixSum += num;
            int temp = prefixSum - k;
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        // System.out.println(subarraySum(nums, k));


        System.out.println(subarraySum(new int[]{1, 2, 3, 4}, 3));
    }
}
