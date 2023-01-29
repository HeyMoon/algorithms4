package com.dyh.algorithms4.blind75.dp;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/11 下午3:24
 * @description: https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();

        System.out.println(uniquePaths.uniquePaths(3, 7));
        System.out.println(uniquePaths.uniquePaths(3, 2));
    }

}
