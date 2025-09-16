package com.aixohub.leetcode.medium.n033;

/**
 * search-in-rotated-sorted-array
 */
public class SearchArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;
            if (nums[mid] == target) return mid;
            if (nums[left] < nums[mid]) {
                if (nums[left] < target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                if (nums[mid] < target && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }


        return -1;
    }
}
