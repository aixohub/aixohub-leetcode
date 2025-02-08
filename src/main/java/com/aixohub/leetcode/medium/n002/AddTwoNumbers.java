package com.aixohub.leetcode.medium.n002;

import com.aixohub.leetcode.node.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // 哑节点
        ListNode current = dummy;
        int carry = 0; // 进位

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // 计算进位
            current.next = new ListNode(sum % 10); // 取个位数作为新节点
            current = current.next;
        }

        return dummy.next;
    }

}
