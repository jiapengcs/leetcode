package com.jiapengcs.leetcode.util;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-2
 *
 * 位运算实现四则运算
 * 一、加法：
 * 1）不考虑进位，分别对各位数进行相加，结果为sum；
 * 2）只考虑进位，结果为carry；
 * 3）如果步骤2所得进位结果carry不为0，对步骤1所得sum，步骤2所得carry重复步骤1、 2、3；
 * 如果carry为0则结束，最终结果为步骤1所得sum。
 * 二、减法：
 * 将减法转换为加法：a - b -> a + (-b)
 * 而负数在计算机中以补码（通过原码取反加一）的形式表示。
 * 三、乘法：
 * 取两数绝对值，参照十进制的竖式计算方法，每次用乘数最低位乘以被乘数，然后乘数右移，被乘数左移，重复计算；
 * 最后判断乘积符号，如果为负则返回积的补码。
 * 四、除法：
 * 依次减去2^31倍, 2^30倍, ..., 2^0倍的除数，最后判断符号位。
 */
public class Calculator {

    public static int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }

    public static int subtract(int a, int b) {
        b = add(~b, 1);
        return add(a, b);
    }

    public static int multiply(int a, int b) {
        int x = a < 0 ? add(~a, 1) : a;
        int y = b < 0 ? add(~b, 1) : b;
        int product = 0;
        while (y > 0) {
            if ((y & 1) == 1) {
                product = add(product, x);
            }
            x <<= 1;
            y >>= 1;
        }
        if ((a ^ b) < 0) {
            product = add(~product, 1);
        }
        return product;
    }

    public static int divide(int a, int b) {
        int dividend = a < 0 ? add(~a, 1) : a;
        int divisor = b < 0 ? add(~b, 1) : b;
        int quotient = 0;
        for (int i = 31; i >= 0; i = subtract(i, 1)) {
            //这里不能用dividend >= (divisor << i)判断，因为左移可能导致溢出
            if ((dividend >> i) >= divisor) {
                quotient = add(quotient, 1 << i);
                dividend = subtract(dividend, divisor << i);
            }
        }
        if ((a ^ b) < 0) {
            quotient = add(~quotient, 1);
        }
        return quotient;
    }

    public static void main(String[] args) {
        System.out.println(add(19, 9));
        System.out.println(subtract(19, 9));
        System.out.println(subtract(100, 19));
        System.out.println(multiply(-2, -2));
        System.out.println(divide(0, 0));
    }
}
