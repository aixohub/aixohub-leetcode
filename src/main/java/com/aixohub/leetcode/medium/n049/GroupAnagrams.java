package com.aixohub.leetcode.medium.n049;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars =  str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            map.putIfAbsent(sortedStr, new ArrayList<>());

            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
 }
