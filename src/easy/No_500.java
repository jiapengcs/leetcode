package easy;

import java.util.*;

/**
 * Created by Jiapeng on 2017/6/27.
 */
public class No_500 {
    public static String[] findWords(String[] words) {
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            if (word.matches("^[qwertyuiopQWERTYUIOP]+$") || word.matches("^[asdfghjklASDFGHJKL]+$") || word.matches("^[zxcvbnmZXCVBNM]+$")) {
                answer.add(word);
            }
        }
        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}
