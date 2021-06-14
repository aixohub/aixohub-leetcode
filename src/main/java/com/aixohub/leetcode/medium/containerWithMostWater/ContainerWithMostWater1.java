package com.aixohub.leetcode.medium.containerWithMostWater;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 *
 * 输入：height = [1,2,1]
 * 输出：2
 *
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 */
public class ContainerWithMostWater1 {

    public static void main(String[] args) {
       int [] height = {4,3,2,1,4};

        int i = maxArea(height);
        System.out.println(i);
    }


    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int ans = 0;
        while(left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] <= height[right]) {
                ++left;
            }else{
                right--;
            }
        }
        return ans;
    }
}
