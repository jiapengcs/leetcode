package com.jiapengcs.leetcode.jianzhioffer;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-22
 *
 * 45.扑克牌顺子
 *
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。
 * 为了方便起见,你可以认为大小王是0。
 *
 * 分析：此题不难，但是用到了bitmap的思想，当计数值不大于64（即int的位数）时，可以用int值的二进制来记录信息。
 * bitmap可以用于判重，还可以用于排序。
 */
public class No_45 {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        int max = 0x80000000, min = 0x7fffffff, bitmap = 0;
        for (int num : numbers) {
            if (num == 0) {
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (num > 13 || num < 0 || max - min > 4 || (bitmap >> num & 1) == 1) {
                return false;
            }
            bitmap |= (1 << num);
        }
        return true;
    }
}
