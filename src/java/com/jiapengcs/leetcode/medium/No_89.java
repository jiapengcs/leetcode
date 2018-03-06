package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-4
 *
 * 89. Gray Code
 *
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 *
 * 分析：格雷码，详见https://baike.baidu.com/item/%E6%A0%BC%E9%9B%B7%E7%A0%81/6510858?fr=aladdin&fromid=11296193&fromtitle=Gray+code
 * 公式：
 * 1. 二进制 => 格雷码： G(i) = B(i) ^ B(i+1), n - 1 >= i >= 0;
 * 2. 格雷码 => 二进制： B(i) = G(i) ^ B(i+1), n - 1 >= i >= 0.
 */
public class No_89 {
    public List<Integer> grayCode(int n) {
        int count = 1 << n;
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            answer.add(i ^ i>>1);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new No_89().grayCode(3));
    }
}
