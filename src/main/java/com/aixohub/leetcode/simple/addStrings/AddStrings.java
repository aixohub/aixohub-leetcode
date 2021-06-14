package com.aixohub.leetcode.simple.addStrings;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 */
public class AddStrings {

    public static void main(String[] args) {
        String a = "234";
        String b = "2342";
        String ss = addStrings(a, b);
        System.out.println(ss);

    }

    public static String addStrings(String num1, String num2) {
        int num1Length = num1.length() - 1;
        int num2Length = num2.length() - 1;
        int carry = 0;
        StringBuffer ans = new StringBuffer();
        while (num1Length >= 0 || num2Length >= 0 || carry != 0) {
            int i = num1Length >= 0 ? num1.charAt(num1Length) - '0' : 0;
            int j = num2Length >= 0 ? num2.charAt(num2Length) - '0' : 0;
            int temp = i + j + carry;
            carry = temp / 10;
            ans.append(temp % 10);
            num1Length--;
            num2Length--;
        }
        return ans.reverse().toString();
    }
}
