package com.jiapengcs.leetcode.hard;

import java.util.*;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-4
 *
 * 30. Substring with Concatenation of All Words
 *
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once
 * and without any intervening characters.
 *
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 *
 * 题意：words数组包含多个长度相同的字符串，以任意顺序拼接所有字符串，如果给定的s中包含这样的字符串，输出其起始下标。
 * 分析：参考438题的滑动窗口的思路。
 * 对于s = "aaaabbbaaa", words = ["aaa","aaa","bbb"]:
 * 1. 我们以步长为3来遍历，即aaa, abb, baa；
 * 2. 这样我们没有遍历到bbb的组合，因此我们再从第二位开始遍历一次，即aaa, bbb, aaa；
 * 3. 同样再从第三位开始遍历一次，即aab, bba；
 * 没有必要再从第四位开始遍历一次，因为与第一次遍历重复了。所以只需重复遍历wordLen次。
 */
public class No_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int wordLen = words[0].length(), arrayLen = words.length;
        for (int i = 0; i < wordLen; i++) {  // 一共需要遍历wordLen次
            int head = i, tail = i, count = arrayLen;  // 初始化
            while (tail + wordLen <= s.length()) {
                String x = s.substring(tail, tail + wordLen);
                if (map.containsKey(x)) {  // 字符串x在hash中
                    if (map.get(x) > 0) {  // 计数值大于0时，说明能匹配，count减一
                        count--;
                    }
                    map.put(x, map.get(x) - 1);
                }
                tail += wordLen;  // 无论字符串x在不在hash中，tail都要后移
                if (count == 0) {
                    ans.add(head);  // count减为0，说明完全匹配，记录head
                }
                if (tail - head == wordLen * arrayLen) {  // tail和head距离超过窗口大小
                    String y = s.substring(head, head + wordLen);
                    if (map.containsKey(y)) {
                        if (map.get(y) >= 0) {  // 计数值不小于0，说明y曾经是匹配的，count加一
                            count++;
                        }
                        map.put(y, map.get(y) + 1);
                    }
                    head += wordLen;  // head右移
                }
            }
            while (head < tail) {  // 初始化，恢复遍历前的状态以便下一次遍历
                String y = s.substring(head, head + wordLen);
                if (map.containsKey(y)) {
                    if (map.get(y) >= 0) {
                        count++;
                    }
                    map.put(y, map.get(y) + 1);
                }
                head += wordLen;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new No_30().findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
        System.out.println(new No_30().findSubstring("aaaabbbaaaaaaaaaa", new String[]{"aaa","aaa","bbb"}));
        System.out.println(new No_30().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }
}
