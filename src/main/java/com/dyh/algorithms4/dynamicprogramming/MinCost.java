package com.dyh.algorithms4.dynamicprogramming;

/**
 * @author: dengyunhui
 * @datetime: 2022/2/9 下午12:01
 * @description:
 */
public class MinCost {

    public static int min(int x, int y, int z) {
        if (x < y && x < z) return x;
        if (y < x && y < z) return y;

        return z;
    }

    public static int count(int[][] arr, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = arr[0][0];

        //初始化第一列
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }

        //初始化第一行
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + arr[i][j];
            }
        }

        return dp[m][n];
    }

    public static void main(String args[]) {
        int cost[][] = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};

        System.out.println(MinCost.count(cost, 2, 2));
    }
}
