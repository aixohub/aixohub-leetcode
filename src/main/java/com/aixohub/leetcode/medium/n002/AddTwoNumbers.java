package com.aixohub.leetcode.medium.n002;

import com.aixohub.leetcode.node.ListNode;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3); // l1 = [2,4,3]

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4); // l2 = [5,6,4]


        ListNode result = addTwoNumbers(l1, l2);

    }

}
