package com.aixohub.leetcode.medium.n142;

import com.aixohub.leetcode.node.ListNode;

public class DetectCycle {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // 链表为空或只有一个节点时不可能有环
        }

        ListNode slow = head;
        ListNode fast = head;

        // 检测是否存在环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 有环，寻找环的起点
                ListNode pointer = head;
                while (pointer != slow) {
                    pointer = pointer.next;
                    slow = slow.next;
                }
                return pointer; // 返回环的起点
            }
        }
        return null; // 没有环
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // 构成环，环的起始点是第二个节点


        ListNode cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("环的起始节点值是：" + cycleStart.val);
        } else {
            System.out.println("链表中没有环");
        }
    }

}
