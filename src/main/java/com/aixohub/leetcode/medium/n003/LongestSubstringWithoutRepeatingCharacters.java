package com.aixohub.leetcode.medium.n003;

import java.util.HashMap;

/**
 * <pre>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *  示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * </pre>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }



    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int maxLength = 0;
        HashMap<Character, Integer> charIndex = new HashMap<>();

        for (int start = 0, end = 0; end < n; end++) {
            if (charIndex.containsKey(s.charAt(end)) && charIndex.get(s.charAt(end)) >= start) {
                // 如果字符已经在窗口中出现过，并且上一次出现的位置在窗口内，更新窗口的起始位置
                start = charIndex.get(s.charAt(end)) + 1;
            }

            // 更新字符的最新位置
            charIndex.put(s.charAt(end), end);

            // 更新最长子串的长度
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
