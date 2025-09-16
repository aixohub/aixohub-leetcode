package com.aixohub.leetcode.medium.n215;

import java.util.PriorityQueue;

public class KthLargestInArray {


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k){
                queue.poll();
            }
        }

        return queue.peek();
    }
}

