package com.aixohub.leetcode.simple.mergeTwoSortedLists;

import com.aixohub.leetcode.node.ListNode;

import java.io.IOException;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) throws IOException {
        ListNode l1 = ListNode.stringToListNode("1,2,4");
        ListNode l2 = ListNode.stringToListNode("1,3,4");

        ListNode ret = MergeTwoSortedLists.mergeTwoLists(l1, l2);

        String s = ListNode.listNodeToString(ret);
        System.out.println(s);


    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }





}