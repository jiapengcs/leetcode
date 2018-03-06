package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 451. Sort Characters By Frequency
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 * Input:
 * "tree"
 * Output:
 * "eert"
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 * Example 2:
 * Input:
 * "cccaaa"
 * Output:
 * "cccaaa"
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 * Example 3:
 * Input:
 * "Aabb"
 * Output:
 * "bbAa"
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 * 分析：按出现频率对字符排序。
 * 方法一：桶排序，首先用HashMap统计每个字符出现的次数，然后按次数放入相应的桶中，从后往前输出桶中的元素。
 * 方法二：堆排序，首先用HashMap统计每个字符出现的次数，然后自定义Map.Entry的比较规则，使用PriorityQueue进行堆排序。见347题。
 */
public class No_451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Character>[] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int times = map.get(key);
            if (bucket[times] == null) {
                bucket[times] = new ArrayList<>();
            }
            bucket[times].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int times = bucket.length - 1; times > 0; times--) {
            if (bucket[times] != null) {
                for (char ch : bucket[times]) {
                    for (int j = 0; j < times; j++) {
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
    }
}
