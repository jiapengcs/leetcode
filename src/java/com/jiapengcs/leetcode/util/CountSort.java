package com.jiapengcs.leetcode.util;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-8
 */
public class CountSort {

    //摘抄自网络
    public static void countSort(int[] array, int range) throws Exception {
        if (range <= 0) {
            throw new Exception("range can't be negative or zero.");
        }

        if (array.length <= 1) {
            return;
        }

        int[] countArray = new int[range + 1];
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (value < 0 || value > range) {
                throw new Exception("array element overflow range.");
            }
            countArray[value] += 1;  //类似于基数排序，统计每个元素的个数
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];  //计算每个桶的右边界
        }

        int[] temp = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {  //从对应桶的右边界往左放，为了排序的稳定，元素组从后往前遍历
            int value = array[i];
            int position = countArray[value] - 1;

            temp[position] = value;  //分散到对应的桶中
            countArray[value] -= 1;  //桶的边界左移
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];  //从桶中取回所有元素
        }
    }

    public static void main(String[] args) throws Exception {
        int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 6, 1, 0 };

        System.out.println("Before sort:");
        System.out.println(Arrays.toString(array));

        countSort(array, 9);

        System.out.println("After sort:");
        System.out.println(Arrays.toString(array));
    }
}
