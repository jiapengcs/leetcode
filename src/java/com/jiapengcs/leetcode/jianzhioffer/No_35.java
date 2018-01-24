package com.jiapengcs.leetcode.jianzhioffer;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-17
 *
 * 35.数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 分析：暴力法的复杂度为O(n^2)
 * 采用归并排序的思想，将数组划分为两部分，从这两部分的末尾开始比较，前半部分的元素大于后半部分则构成逆序对。
 * 复杂度为O(nlogn)。
 */
public class No_35 {
    public static int InversePairs(int [] array) {
        if (array == null) {
            return 0;
        }
        return mergeSort(array, new int[array.length], 0, array.length-1);
    }

    public static int mergeSort(int[] array, int[] tmp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int left = mergeSort(array, tmp, start, mid);
        int right = mergeSort(array, tmp, mid+1, end);
        return (left + right + merge(array, tmp, start, mid, end)) % 1000000007;
    }

    // eg: 2 6 | 1 5
    public static int merge(int[] array, int[] tmp, int start, int mid, int end) {
        int leftTail = mid, rightTail = end, count = 0;
        int index = end;
        // 对左右两部分从后往前比较
        while (leftTail >= start && rightTail >= mid + 1) {
            // 6大于5，则6大于右半部分5之前的所有元素，count值加上相应的个数，将6拷贝至临时数组（从后往前）
            if (array[leftTail] > array[rightTail]) {
                count += rightTail - mid;
                count %= 1000000007;
                tmp[index--] = array[leftTail--];
            } else {
                // 2小于5，直接将5拷贝至临时数组
                tmp[index--] = array[rightTail--];
            }
        }
        // 拷贝左半部分剩余元素
        while (leftTail >= start) {
            tmp[index--] = array[leftTail--];
        }
        // 拷贝右半部分剩余元素
        while (rightTail >= mid + 1) {
            tmp[index--] = array[rightTail--];
        }
        // 将临时数组中排好序的元素拷贝回原数组
        for (int i = start; i <= end; i++) {
            array[i] = tmp[i];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(InversePairs(new int[]{2,3,4,2,6,2,5,1}));
    }
}
