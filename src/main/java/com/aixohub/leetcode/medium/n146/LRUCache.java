package com.aixohub.leetcode.medium.n146;

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        long la = lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        long lb =  lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        long lv = lRUCache.get(1);    // 返回 -1 (未找到)
        long ln =  lRUCache.get(3);    // 返回 3
        long lm = lRUCache.get(4);    // 返回 4
    }

     class CacheNode {
         int key;
         int value;
         CacheNode prev, next;

        CacheNode() {
        }

        CacheNode(int k, int v) {
            key = k;
            value = v;
        }
    }

    private long capacity;

    private CacheNode head, tail;

    private long size;

    public LRUCache(long capacity) {
        this.capacity = capacity;
        head = new CacheNode();
        tail = new CacheNode();
        head.next = tail;
        tail.prev = head;
    }

    Map<Integer, CacheNode> keyMap = new HashMap<>();

    int get(int k) {
        CacheNode cacheNode = keyMap.get(k);
        if (cacheNode == null) {
            return -1;
        } else {
            moveToHead(cacheNode);
            return cacheNode.value;
        }
    }

    void put(int k, int v) {
        CacheNode cacheNode = keyMap.get(k);
        if (cacheNode != null) {
            cacheNode.value = v;
            moveToHead(cacheNode);
        } else {
            cacheNode = new CacheNode(k, v);
            keyMap.put(k, cacheNode);
            addToHead(cacheNode);
            size++;
            if (size > capacity) {
                CacheNode tailNode = removeTailNode();
                keyMap.remove(tailNode.key);
                size --;
            }

        }
    }

    CacheNode removeTailNode() {
        CacheNode tailNode =  tail.prev;
        removeNode(tailNode);
        return tailNode;
    }


    void removeNode(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addToHead(CacheNode node) {

        node.prev= head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;


    }
    void moveToHead(CacheNode node) {
        removeNode(node);
        addToHead(node);
    }

}
