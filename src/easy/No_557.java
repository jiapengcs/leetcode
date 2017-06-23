package easy;

/**
 * Created by Jiapeng on 2017/6/23.
 */
public class No_557 {
    // TC: O(n), SC: O(1)
    public static String reverseWords(String s) {
        String answer = "";
        for (String t : s.split(" "))
            answer = answer.concat(new StringBuffer(t).reverse() + " ");
        return answer.trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
