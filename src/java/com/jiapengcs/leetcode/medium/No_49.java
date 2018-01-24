package com.jiapengcs.leetcode.medium;

import java.util.*;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-15
 *
 * 49. Group Anagrams
 *
 * Given an array of strings, group anagrams together.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * [
 *  ["ate", "eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ]
 *
 * Note: All inputs will be in lower-case.
 *
 * 分析：
 * Hash法
 * 同一组单词的组成字母相同，按字母表排序后唯一，可以作为Map的key，
 * 用HashMap记录相同组成的字符串。
 */
public class No_49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
