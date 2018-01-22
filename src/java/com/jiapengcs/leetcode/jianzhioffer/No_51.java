package com.jiapengcs.leetcode.jianzhioffer;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-17
 *
 * 51.构建乘积数组
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * 分析：分两步，先从左到右将i以前的A[i]的累积赋值给B[i]，然后从右往左将i以后的A[i]的累积乘到B[i]
 */
public class No_51 {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int len = A.length, tmp = A[0];
        int[] B = new int[len];
        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = tmp;
            tmp *= A[i];
        }
        tmp = A[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            B[i] *= tmp;
            tmp *= A[i];
        }
        return B;
    }
}
