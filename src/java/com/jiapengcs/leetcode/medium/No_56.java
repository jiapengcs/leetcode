package com.jiapengcs.leetcode.medium;

import java.util.*;

/**
 * Created by Jiapeng 2017/10/19.
 *
 * 56. Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 * 分析：先按start大小排序。然后从左到右遍历，如果前一个的end不小于后一个的start，则将二者合并到前者并删除后者；否则继续向后遍历。
 */
public class No_56 {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    // TC: O(nlog(n)), SC: O(1)
    public static List<Interval> merge(List<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        int i = 0;
        while (i < intervals.size() - 1) {
            if (intervals.get(i).end >= intervals.get(i + 1).start) {
                intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
                intervals.remove(i + 1);
            } else {
                i++;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> params = new ArrayList<>();
        params.add(new Interval(1, 3));
        params.add(new Interval(2, 6));
        params.add(new Interval(8, 20));
        params.add(new Interval(15, 18));
        System.out.println(merge(params));
    }
}
