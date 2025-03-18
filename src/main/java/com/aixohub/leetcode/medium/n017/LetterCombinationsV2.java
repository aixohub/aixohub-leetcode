package com.aixohub.leetcode.medium.n017;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsV2 {
    // 数字到字母的映射
    private static final String[] LETTERS = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // 如果当前组合长度等于输入字符串长度，将其加入结果列表
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // 获取当前数字对应的字母
        char digit = digits.charAt(index);
        String letters = LETTERS[digit - '0'];

        // 遍历当前数字对应的所有字母
        for (char letter : letters.toCharArray()) {
            current.append(letter); // 选择当前字母
            backtrack(result, current, digits, index + 1); // 递归处理下一个数字
            current.deleteCharAt(current.length() - 1); // 撤销选择（回溯）
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> combinations = letterCombinations(digits);
        System.out.println("Letter combinations for " + digits + ": " + combinations);
    }
}
