package com.jiapengcs.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 140. Word Break II
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * You may assume the dictionary does not contain duplicate words.
 *
 * Return all such possible sentences.
 *
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 *
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings).
 * Please reload the code definition to get the latest changes.
 *
 * 分析：给定一个字符串和一个字典，求字符串按字典中的单词的所有划分。
 * 可以采用回溯法，但是此题会超时。
 * 用HashMap记录子串的划分结果，再次遇到相同的子串时，直接从HashMap中取划分结果，这样降低了复杂度。
 */
public class No_140 {

    //摘自讨论区
    //用map保存某个子串对应的划分结果，如{"catsanddog":["cats and dog", "cat sand dog"], "sanddog":["sand dog"]}
    private Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s))  //该子串已经划分过，直接从map取划分结果
            return map.get(s);
        List<String> res = new LinkedList<>();
        if (s.length() == 0) return null;
        for (String word : wordDict) {
            if (s.startsWith(word)) {  //子串的开头匹配字典中某个word
                List<String> sublist = wordBreak(s.substring(word.length()), wordDict);  //递归计算剩余子串的划分
                if (sublist == null) {
                    res.add(word);  //剩余子串为空，则将开头加入当前结果
                } else {
                    for (String sub : sublist) {  //剩余子串非空，则将开头与剩余子串的划分结果拼接，并加入当前结果
                        res.add(word + " " + sub);
                    }
                }
            }
        }
        map.put(s, res);  //将子串的划分结果存入map
        return res;
    }
}
