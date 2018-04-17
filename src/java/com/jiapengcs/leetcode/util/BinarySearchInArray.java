package com.jiapengcs.leetcode.util;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2018/1/7
 */
public class BinarySearchInArray {

    /**
     * 二分查找翻转后的有序数组的最小值，可以应对出现重复元素的情况。
     * 1）先考虑没有重复元素的情况：(eg: 2, 3, 4, 1)、(eg: 4, 1, 2, 3)
     * 如果mid位置的元素大于high位置的元素，则最小值一定在mid位置的右边，即mid+1到high；否则最小值出现在low到mid，
     * 这也就解释了为什么low = mid + 1, 而high = mid。
     * 2）再看有重复元素的情况：(eg: 3, 3, 3, 2, 3)、(eg: 3, 2, 3, 3, 3)
     * 这种情况下，可能出现mid和low、high三个位置上的元素都相等的情况，导致我们无法判断最小值出现在那一边，
     * 解决方法是将跳过low和high位置的元素，即low--, high++。
     * @param array
     * @return
     */
    // 待验证
    public static int searchMin(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0, high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] == array[low] && array[mid] == array[high]) {
                low++;
                high--;
            } else if (array[mid] > array[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        System.out.println(searchMin(new int[]{3,3,3,2,2,2,3,3}));
        System.out.println(searchMin(new int[]{3,3}));
    }
}
