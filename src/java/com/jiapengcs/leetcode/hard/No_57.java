package com.jiapengcs.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiapeng 2017/10/19.
 *
 * 57. Insert Interval
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 *
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 * 分析：因为intervals有序，从左向右查找第一个end不小于newInterval.start的元素位置，
 * 从右向左查找第一个start不大于newInterval.end的元素位置，这个区间即newInterval能覆盖到的区间。
 * 如果这两个位置不相同，则将这个区间内的元素合并到newInterval，再删去这个区间并在该位置插入新的newInterval；
 * 否则直接在这个位置插入newInterval。
 */
public class No_57 {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    // TC: O(n), SC: O(1)
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        int low = 0, high = intervals.size();
        // if record position by i, when got i = intervals.size(), the real position is uncertain.
        for (int i = 0; i < intervals.size() && intervals.get(i).end < newInterval.start; i++, low++);
        for (int j = intervals.size() - 1; j >= 0 && intervals.get(j).start > newInterval.end; j--, high--);
        if (low != high) {
            newInterval.start = Math.min(newInterval.start, intervals.get(low).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(high - 1).end);
            for (int i = high - 1; i >= low; i--) {
                intervals.remove(i);
            }
        }
        intervals.add(low, newInterval);
        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> params = new ArrayList<>();
        params.add(new Interval(1, 2));
        params.add(new Interval(3, 5));
        params.add(new Interval(6, 7));
        params.add(new Interval(8, 10));
        params.add(new Interval(12, 16));
        System.out.println(insert(params, new Interval(4, 9)));
    }
}
