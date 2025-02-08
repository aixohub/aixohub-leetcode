package com.aixohub.leetcode.simple.n543;

import com.aixohub.leetcode.node.TreeNode;

/**
 * 543. 二叉树的直径
 *
 */
public class DiameterOfBinaryTree {

    private static int maxDiameter = 0;  // 用于记录最大直径

    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);  // 计算深度，同时更新最大直径
        return maxDiameter;
    }

    private static int depth(TreeNode node) {
        if (node == null) return 0;  // 空节点深度为 0

        int leftDepth = depth(node.left);   // 递归计算左子树深度
        int rightDepth = depth(node.right); // 递归计算右子树深度

        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth); // 更新最大直径

        return Math.max(leftDepth, rightDepth) + 1; // 返回当前节点的深度
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }

}
