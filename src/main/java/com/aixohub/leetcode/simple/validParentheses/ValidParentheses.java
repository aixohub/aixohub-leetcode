package com.aixohub.leetcode.simple.validParentheses;

import com.google.common.primitives.Chars;

import java.nio.charset.Charset;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if(s.length() % 2 == 1){
            return false;
        }
        Map<Character, Character> dict = new HashMap<Character, Character>(){{
            put('}', '{');
            put(']', '[');
            put(')', '(');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(dict.containsKey(s.charAt(i))){
                if(stack == null || stack.peek() != dict.get(s.charAt(i))){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
