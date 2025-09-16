package com.aixohub.leetcode.hard.n025;

import com.aixohub.leetcode.node.ListNode;

public class ReverseKGroup25 {


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = head;
        for (int i = 0; i < k; i++) {
            if (dummy == null){
                return head;
            }
            dummy = dummy.next;
        }
        ListNode prev = null, curr = head, next = null;
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
