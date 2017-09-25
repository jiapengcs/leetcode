package com.jiapengcs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiapeng on 2017/9/18.
 *
 * 125. Valid Palindrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 */
public class No_125 {
    // TC: O(n), SC: O(1)
    public static boolean isPalindrome(String s) {
        int head = 0, tail = s.length() - 1;
        while (head < tail) {
            char cl = 0, cr = 0;
            while (!Character.isLetterOrDigit(cl) && head < s.length())
                cl = s.charAt(head++);
            while (!Character.isLetterOrDigit(cr) && tail >= 0)
                cr = s.charAt(tail--);
            if (head < s.length() && Character.toLowerCase(cl) != Character.toLowerCase(cr))
                return false;
        }
        return true;
    }

    // TC: O(n), SC: O(n)
    public static boolean isPalindrome2(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
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
