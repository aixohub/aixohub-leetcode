package com.aixohub.leetcode.medium.n208;

/***
 * <pre>
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 *
 * 示例：
 *
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 *
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *
 * </pre>
 * <a href="https://leetcode.cn/problems/implement-trie-prefix-tree"> implement-trie-prefix-tree </a>
 */
public class Trie {
    // 定义前缀树的节点
    private class TrieNode {
        private TrieNode[] children; // 子节点
        private boolean isEnd; // 是否是一个完整单词的结尾

        public TrieNode() {
            children = new TrieNode[26]; // 假设只有小写字母 a-z
            isEnd = false; // 初始化时，节点不是单词的结尾
        }
    }

    private TrieNode root; // 前缀树的根节点

    // 构造函数，初始化根节点
    public Trie() {
        root = new TrieNode();
    }

    // 插入单词
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // 计算字符对应的索引
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); // 创建新节点
            }
            node = node.children[index]; // 移动到子节点
        }
        node.isEnd = true; // 标记单词结尾
    }

    // 查找单词是否存在
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    // 检查是否存在以 prefix 为前缀的单词
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    // 辅助函数：查找前缀对应的节点
    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null; // 前缀不存在
            }
            node = node.children[index];
        }
        return node; // 返回前缀对应的最后一个节点
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true

        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }
}
