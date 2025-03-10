package com.aixohub.leetcode.hard.n025;

import com.aixohub.leetcode.node.ListNode;

/**
 * leetcode 52
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. 先检查是否有 k 个节点，不足 k 个直接返回
        ListNode temp = head;
        for (int i= 0; i <k ;i++){
            if (temp == null) {
                return head;
            }
            temp = head.next;
        }
        // 2. 反转 k 个节点
        ListNode prev = null, curr = head, next = null;
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 3. 递归处理剩余部分
        head.next = reverseKGroup(curr, k);

        // 4. 返回新的头节点
        return prev;
    }
}
