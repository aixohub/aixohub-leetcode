package com.aixohub.leetcode.hard.n023;

import com.aixohub.leetcode.node.ListNode;

import java.util.PriorityQueue;

public class MergeKLists {

    public static void main(String[] args) {
        // 创建测试链表
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {l1, l2, l3};

        ListNode result = mergeKLists(lists);

        // 输出合并后的链表
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 定义优先队列，按照节点的值升序排列
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 将所有链表的头节点加入优先队列
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // 创建一个虚拟头节点，用于构建结果链表
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // 从优先队列中取出最小节点，加入结果链表
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;

            // 如果当前节点的下一个节点不为空，将其加入优先队列
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return dummy.next;
    }
}
