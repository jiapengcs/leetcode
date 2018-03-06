package com.jiapengcs.leetcode.util;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-11
 *
 * LFU算法的设计与实现(讨论区答案)
 */
public class LFUCache {

    private Map<Integer, Integer> cache;
    private Map<Integer, Integer> counts;
    private Map<Integer, LinkedHashSet<Integer>> expires;
    private int capacity;
    private int min;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        counts = new HashMap<>();
        expires = new HashMap<>();
        this.capacity = capacity;
        expires.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        int count = counts.get(key);
        counts.put(key, count + 1);
        expires.get(count).remove(key);
        if (count == min && expires.get(min).size() == 0) {
            min++;
        }
        if (!expires.containsKey(count + 1)) {
            expires.put(count + 1, new LinkedHashSet<>());
        }
        expires.get(count + 1).add(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (cache.containsKey(key)) {
            cache.put(key, value);
            get(key);
        } else {
            if (cache.size() == capacity) {
                int out = expires.get(min).iterator().next();
                cache.remove(out);
                counts.remove(out);
                expires.get(min).remove(out);
            }
            cache.put(key, value);
            counts.put(key, 1);
            expires.get(1).add(key);
            min = 1;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(4));
        System.out.println(cache.get(1));
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(5, 5);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
