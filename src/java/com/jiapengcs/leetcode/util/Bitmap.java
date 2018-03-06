package com.jiapengcs.leetcode.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-26
 *
 * 输出所有出现过的字符，相同字符不能重复输出。
 * 分析：Bitmap思想（位图法）。用1个比特位来记录对应值是否出现，以int类型为例，一个int值32位，可以记录32个字符是否出现。
 * char类型取值范围为0~2^16-1，因此可以用2^11个int值作为bitmap。大小确定（2^11 * 4B = 8KB），因此空间复杂度为O(1).
 *
 * 引申：如果题目改为输出只出现一次的字符，则可以用2个比特位来记录对应字符的状态，
 * 00表示未出现，01表示出现一次，10表示出现多次，11不使用。
 */
public class Bitmap {
    // TC: O(n), SC: O(1)
    public List<Character> noRepeatChar(String string) {
        List<Character> result = new ArrayList<>();
        int[] bitmap = new int[1 << 11];
        for (char ch : string.toCharArray()) {
            int index = ch / 32;
            int bit = ch % 32;
            bitmap[index] |= (1 << bit);
        }
        for (int index = 0; index < bitmap.length; index++) {
            for (int i = 0; i < 32; i++) {
                if (((bitmap[index] >> i) & 1) == 1) {
                    char target = (char) (index * 32 + i);
                    result.add(target);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Bitmap().noRepeatChar("asdfaxvcx你好"));
    }
}
