package com.aixohub.leetcode.medium.n146;

import java.util.HashMap;
import java.util.Map;

public class LRCache {

    class Node {
        int key, value;

        Node pred;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    long size;
    long maxSize;
    Node head, tail;
    Map<Integer, Node> keyMap = new HashMap<>();

    public LRCache(long maxSize) {
        this.maxSize = maxSize;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pred = head;
    }

    public void put(int key, int value) {
        Node node = keyMap.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        node = new Node(key, value);
        keyMap.put(key, node);
        addToHead(node);
        size++;
        if (size > maxSize) {
            Node tail = removeTailNode();
            keyMap.remove(tail.key);
            size --;
        }
    }

    public long get(int key) {
        Node node = keyMap.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }


    void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }


    void removeNode(Node node) {
        node.next.pred = node.pred;
        node.pred.next = node.next;
    }


    void addToHead(Node node) {

        node.next = head.next;
        node.pred = head;

        head.next.pred =node;
        head.next = node;
    }

    Node removeTailNode(){
        Node node = tail.pred;
        removeNode(node);
        return node;
    }
}
