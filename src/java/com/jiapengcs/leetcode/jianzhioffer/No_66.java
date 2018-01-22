package com.jiapengcs.leetcode.jianzhioffer;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-17
 *
 * 66.机器人的运动范围
 *
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 分析：回溯法，类似leetcode 130. Surrounded Regions的解法
 * 这道题不能简单的遍历m * n个坐标判断有多少个合法坐标，因为有些坐标虽然是合法的，但如果被不合法的坐标围住了是无法到达的。
 * 例如1 * 100的方格，k为10，从(0, 0)出发，走到(0, 28)就不能再往后走了，即便(0, 30)是合法坐标，但无法到达。
 * 应采用回溯法，从(0, 0)开始，判断上下左右是否合法坐标：是则继续往前走，同时对走过的坐标进行标记和计数；否则回退。
 */
public class No_66 {
    public int movingCount(int threshold, int rows, int cols) {
        char[][] map = new char[rows][cols];
        return dfs(map, threshold, 0, 0);
    }

    public int dfs(char[][] map, int threshold, int x, int y) {
        if (x < 0 || x > map.length-1 || y < 0 || y > map[0].length-1 || getSum(x, y) > threshold || map[x][y] == 'X') {
            return 0;
        }
        map[x][y] = 'X';
        return 1 + dfs(map, threshold, x-1, y)
                + dfs(map, threshold, x+1, y)
                + dfs(map, threshold, x, y-1)
                + dfs(map, threshold, x, y+1);
    }

    public int getSum(int a, int b) {
        int sum = 0;
        while (a > 0 || b > 0) {
            sum += a % 10 + b % 10;
            a /= 10;
            b /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new No_66().movingCount(10, 1, 100));
    }
}
