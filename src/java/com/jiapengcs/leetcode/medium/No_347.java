package com.jiapengcs.leetcode.medium;

import java.util.*;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 347. Top K Frequent Elements
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * 分析：求前K个出现最频繁的元素。
 * 方法一：桶排序，首先用HashMap统计每个数字出现的次数，然后按次数放入相应的桶中，从后往前输出桶中的元素。见451题。
 * 方法二：堆排序，首先用HashMap统计每个数字出现的次数，然后自定义Map.Entry的比较规则，使用PriorityQueue进行堆排序。
 */
public class No_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int times = map.get(key);
            if (bucket[times] == null) {
                bucket[times] = new LinkedList<>();
            }
            bucket[times].add(key);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0 && k > 0; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    ans.add(num);
                    k--;
                }
            }
        }
        return ans;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }
        List<Integer> ans = new ArrayList<>();
        while (ans.size() < k) {
            Map.Entry<Integer,Integer> entry = maxHeap.poll();
            ans.add(entry.getKey());
        }
        return ans;
    }
}
