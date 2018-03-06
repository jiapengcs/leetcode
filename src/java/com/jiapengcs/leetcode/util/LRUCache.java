package com.jiapengcs.leetcode.util;

import java.util.*;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-9
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * LRU算法的设计与实现
 * 1. get方法要求复杂度为O(1)，因此需要借助HashMap；
 * 2. 为了决定淘汰的结点，需要借助一个队列来记录结点的访问顺序，get过的结点移到队头，刚put的结点插入到队头，
 * 如果缓存已满，则移除队尾结点，同时从HashMap中删除该结点；
 * 3. 使用JDK自带的队列在移动或删除结点时需要遍历队列查找结点，复杂度为O(n)；如果自定义数据结构和双向链表，
 * 则可以在HashMap中存入结点对象，这样就可以直接操作链表，使用双向链表的原因是可以将操作链表的复杂度降为O(1)。
 *
 * get方法和put方法的时间复杂度均为O(1).
 */
public class LRUCache {

    class CacheNode {
        int key;
        int value;
        CacheNode pre;
        CacheNode next;
    }

    private Map<Integer, CacheNode> cache;
    private CacheNode first, last;
    private int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        first = new CacheNode();
        last = new CacheNode();
        first.pre = null;
        first.next = last;
        last.pre = first;
        last.next = null;
        this.capacity = capacity;
    }

    public int get(int key) {
        CacheNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            node.value = value;
            moveToFirst(node);
        } else {
            if (cache.size() == capacity) {
                CacheNode out = last.pre;
                remove(out);
                cache.remove(out.key);
            }
            CacheNode node = new CacheNode();
            node.key = key;
            node.value = value;
            cache.put(key, node);
            addFirst(node);
        }
    }

    private void addFirst(CacheNode node) {
        node.next = first.next;
        first.next.pre = node;
        first.next = node;
        node.pre = first;
    }

    private void remove(CacheNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToFirst(CacheNode node) {
        remove(node);
        addFirst(node);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(4));
        System.out.println(cache.get(1));
        cache.put(4, 4);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
