package com.aixohub.leetcode.medium.n148;

import com.aixohub.leetcode.node.ListNode;

public class SortList {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode result = new ListNode(0);
        ListNode h = result;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                h = h.next;
                left = left.next;
            } else {
                h.next = right;
                h = h.next;
                right = right.next;
            }
        }
        h.next = left != null ? left : right;

        return result.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);


        ListNode sorted = sortList(head);

        // 打印结果
        while (sorted != null) {
            System.out.print(sorted.val + " ");
            sorted = sorted.next;
        }
        // 输出: 1 2 3 4
    }
}
