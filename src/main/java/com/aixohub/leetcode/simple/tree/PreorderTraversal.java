package com.aixohub.leetcode.simple.tree;

import com.aixohub.leetcode.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.stringToTreeNode("3,9,20,null,null,15,7");
        List<Integer> integers = preorderTraversal(treeNode);

        System.out.println(integers);
    }



    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    static void  preOrder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

}
