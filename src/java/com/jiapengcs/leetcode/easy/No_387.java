package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 387. First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 * 分析：求字符串中第一个不重复的字母。
 * 用数组统计每个字母出现的次数，然后再次遍历字符串，如果某个字母的出现次数为1，输出该字母的下标。
 */
public class No_387 {
    public int firstUniqChar(String s) {
        int[] buf = new int[26];
        for (int i = 0; i < s.length(); i++) {
            buf[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (buf[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
