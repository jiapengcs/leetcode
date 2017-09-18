package com.jiapengcs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiapeng on 2017/9/18.
 */
public class No_125 {
    public static boolean isPalindrome(String s) {
        char[] buf = s.toCharArray();
        for (int i = 0, j = buf.length - 1; i < j; i++, j--) {
            char cl = 0;
            while (!(cl >= 'a' && cl <= 'z' || cl >= 'a' && cl <= 'z' || cl >= 'a' && cl <= 'z' || cl >= '0' && cl <= '9') && i < j)
                cl = Character.toLowerCase(buf[i++]);
            char cr = Character.toLowerCase(buf[j]);
            while (!(cr >= 'a' && cr <= 'z' || cr >= 'a' && cr <= 'z' || cr >= 'a' && cr <= 'z' || cr >= '0' && cr <= '9') && i < j)
                cr = Character.toLowerCase(buf[j--]);
            if (cl != cr) return false;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        char[] buf = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : buf) {
            c = Character.toLowerCase(c);
            if (c >= 'a' && c <= 'z' || c >= '0' && c <='9')
                list.add(c);
        }
        for (int i = 0; i < list.size() / 2; i++)
            if (list.get(i) != list.get(list.size() - i - 1))
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome(".,"));
        System.out.println(isPalindrome("a."));
    }
}
