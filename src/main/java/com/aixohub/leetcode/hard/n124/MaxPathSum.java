package com.aixohub.leetcode.hard.n124;

import com.aixohub.leetcode.node.TreeNode;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 *
 *
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 */
public class MaxPathSum {

    public static void main(String[] args) {
        // 构建二叉树
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        System.out.println(maxPathSum(root)); // 输出: 42
    }

    private static int maxSum = Integer.MIN_VALUE; // 全局变量，记录最大路径和

    public static int maxPathSum(TreeNode root) {
        calculateMaxGain(root); // 开始递归计算
        return maxSum;
    }

    // 递归函数：计算从当前节点出发的最大贡献值
    private static int calculateMaxGain(TreeNode node) {
        if (node == null) {
            return 0; // 空节点的贡献值为 0
        }

        // 递归计算左右子树的最大贡献值（负值直接取 0，表示不选择该路径）
        int leftGain = Math.max(calculateMaxGain(node.left), 0);
        int rightGain = Math.max(calculateMaxGain(node.right), 0);

        // 当前路径和 = 当前节点值 + 左子树最大贡献值 + 右子树最大贡献值
        int currentPathSum = node.val + leftGain + rightGain;

        // 更新全局最大路径和
        maxSum = Math.max(maxSum, currentPathSum);

        // 返回当前节点的最大贡献值（只能选择一条路径返回给父节点）
        return node.val + Math.max(leftGain, rightGain);
    }


}
