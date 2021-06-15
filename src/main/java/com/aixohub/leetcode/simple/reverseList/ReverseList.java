package com.aixohub.leetcode.simple.reverseList;

import com.aixohub.leetcode.simple.node.ListNode;

public class ReverseList {

    public static void main(String[] args) {
        ListNode listNode = ListNode.stringToListNode("1,2,3,4,5");

        ListNode listNode1 = reverseList(listNode);
        String s = ListNode.listNodeToString(listNode1);
        System.out.println(s);
    }



    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
