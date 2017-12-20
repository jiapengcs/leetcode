package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-19
 *
 * 93. Restore IP Addresses
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class No_93 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            if (s.length() - i > 9) {
                continue;
            }
            for (int j = i+1; j <= i+3; j++) {
                if (s.length() - j > 6) {
                    continue;
                }
                for (int k = j+1; k <= j+3 && k < s.length(); k++) {
                    if (s.length() - k > 3) {
                        continue;
                    }
                    int a = Integer.parseInt(s.substring(0, i));
                    int b = Integer.parseInt(s.substring(i, j));
                    int c = Integer.parseInt(s.substring(j, k));
                    int d = Integer.parseInt(s.substring(k));
                    if (a <= 255 && b <= 255 && c <= 255 && d <= 255) {
                        String str = a + "." + b + "." + c + "." + d;
                        if (str.length() == s.length() + 3) {
                            answer.add(str);
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static List<String> restoreIpAddresses2(String s) {
        List<String> answer = new ArrayList<>();
        backtracking(s, 0, "", answer);
        return answer;
    }

    public static void backtracking(String s, int count, String buf, List<String> answer) {
        if (count == 4) {
            answer.add(buf);
            return;
        }
        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            if (s.length() - i > 3 * (3-count)) {
                continue;
            }
            String str = s.substring(0, i);
            int t = Integer.parseInt(str);
            if (t <= 255 && !(str.charAt(0) == '0' && str.length() > 1)) {
                backtracking(s.substring(i), count+1, buf + t + (count == 3 ? "" : "."), answer);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses2("25525511135"));
        System.out.println(restoreIpAddresses2("010010"));
    }
}
