package com.jiapengcs.leetcode.jianzhioffer;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-17
 *
 * 50.数组中重复的数字
 *
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 *
 * 分析：如果此题确定数字的上限，对于出现过的数x作为下标时，让对应的元素numbers[x]加上一个固定偏移量OFFSET，
 * 让它大于上限，下次再出现x时，发现numbers[x]大于上限，即找到重复数字x。
 * 但是此题的本意应该是这样，但由于上限不明确，加偏移量可能会导致溢出。
 */
public class No_50 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for(int i = 0;i < length; i++){
            int index = numbers[i] % length;
            if(numbers[index] >= length){
                duplication[0] = index;
                return true;
            }
            numbers[index] += length;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] duplication = new int[1];
        System.out.println(new No_50().duplicate(new int[]{2,3,1,0,2,5,3}, 7, duplication));
        System.out.println(duplication[0]);
    }
}
