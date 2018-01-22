package com.jiapengcs.leetcode.jianzhioffer;

import java.util.LinkedList;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-22
 *
 * 46.孩子们的游戏(圆圈中最后剩下的数)
 *
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 分析：约瑟夫环问题，可以用数组模拟，但需要维护是否出列的状态。使用LinkedList模拟一个环cycle，出列时删除对应位置的元素。
 * 1. 报数起点为start（初始为0），则出列的位置为out = (start + m - 1) % cycle.size()，删除out位置的元素；
 * 2. 更新起点start = out，重复1直到只剩下一个元素。
 * 时间复杂性、空间复杂度均为O(n)。
 */
public class No_46 {
    // TC: O(n), SC: O(n)
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        LinkedList<Integer> cycle = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            cycle.add(i);
        }
        int start = 0;
        while (cycle.size() > 1) {
            int out = (start + m - 1) % cycle.size();
            cycle.remove(out);
            start = out;
        }
        return cycle.remove();
    }


    /*
    摘抄自讨论区：这道题我用数组来模拟环，思路还是比较简单，但是各种下标要理清
     */
    public static int findLastNumber(int n,int m){
        if(n < 1 || m < 1) return -1;
        int[] array = new int[n];
        int i = -1,step = 0, count = n;
        while(count > 0) {                //跳出循环时将最后一个元素也设置为了-1
            i++;                          //指向上一个被删除对象的下一个元素。
            if(i >= n) i=0;               //模拟环。
            if(array[i] == -1) continue;  //跳过被删除的对象。
            step++;                       //记录已走过的。
            if(step == m) {               //找到待删除的对象。
                array[i]=-1;
                step = 0;
                count--;
            }
        }
        return i;                         //返回跳出循环时的i,即最后一个被设置为-1的元素
    }

    public static void main(String[] args) {
        System.out.println(new No_46().LastRemaining_Solution(8, 10));
        System.out.println(new No_46().LastRemaining_Solution(3, 0));
    }
}
