package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng on 2017/7/12.
 */
public class No_605 {
    // TC: O(n), SC: O(1)
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) return n <= 1;
            else return n == 0;
        }
        if (flowerbed[0] + flowerbed[1] == 0) {
            -- n;
            flowerbed[0] ++;
        }
        for (int i = 1; i < flowerbed.length - 1; i ++) {
            if (flowerbed[i-1] + flowerbed[i] + flowerbed[i+1] == 0) {
                -- n;
                flowerbed[i] ++;
            }
        }
        if (flowerbed[flowerbed.length - 2] + flowerbed[flowerbed.length - 1] == 0) {
            -- n;
        }
        return n <= 0;
    }

    // 摘抄并修改
    // TC: O(n), SC: O(1)
    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                int pre = (i == 0) ? 0 : flowerbed[i - 1];
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                if(pre == 0 && next == 0) {
                    flowerbed[i] = 1;
                    --n;
                }
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers2(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers2(new int[]{0, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers2(new int[]{1}, 0));
        System.out.println(canPlaceFlowers2(new int[]{0}, 1));
        System.out.println(canPlaceFlowers2(new int[]{1, 0}, 1));
    }
}
