package com.aixohub.leetcode.medium.n017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    private static final Map<Character, String> phoneMap = new HashMap<>();

    static {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }

    private static void backtrack(List<String> result, String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);

        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(result, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1); // 回溯
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> combinations = letterCombinations(digits);
        System.out.println("Letter combinations for " + digits + ": " + combinations);
    }
}
