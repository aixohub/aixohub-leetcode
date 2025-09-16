package com.aixohub.leetcode.medium.n003;

import java.util.Arrays;
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
      //  System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring3("abcabcbb"));
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

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex, -1);
        int maxLen = 0;
        int start = 0;
        for (int i=0; i <n; i++) {
            char c = s.charAt(i);
            if (lastIndex[c] >= start) {
                start = lastIndex[c] +1;
            }
            lastIndex[c] = i;
            maxLen = Math.max(maxLen, i - start +1);
        }
        return maxLen;

    }


    /**
     * <pre>
     index数组的特殊含义：

     index[c]存储的不是字符c最后一次出现的位置，而是位置+1

     这样设计可以直接用于left的跳转，无需再+1

     初始时所有值为0，表示字符尚未出现过



     left = Math.max(left, index[c])：

     当字符c重复出现时，index[c]会大于当前的left

     这保证了left只会向右移动，不会回退

     例如：对于字符串"abba"，处理第二个'b'和第二个'a'时的情况

     窗口大小计算：

     right - left + 1就是当前无重复字符子串的长度

     每次迭代都更新max保持最大值
     * </pre>
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        // 初始化一个大小为128的数组（覆盖所有ASCII字符）
        int[] index = new int[128];
        int max = 0;       // 记录最大长度
        int left = 0;      // 滑动窗口左边界

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 关键1：更新左边界
            left = Math.max(left, index[c]);
            // 关键2：记录当前字符的位置（存储的是right+1）
            index[c] = right + 1;
            System.out.println(c + " == " + index[c]  + "  right = " + right + "  left = " + left);

            // 计算当前窗口大小并更新最大值
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
