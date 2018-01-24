package com.jiapengcs.leetcode.jianzhioffer;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-17
 *
 * 47.求1+2+3+...+n
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 分析：由于不能使用关键字实现循环，可以采用递归的方式；
 * 不能使用条件判断语句，可以通过逻辑运算的短路机制来控制递归的终止。
 */
public class No_47 {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean t = sum > 0 && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new No_47().Sum_Solution(100));
    }
}
