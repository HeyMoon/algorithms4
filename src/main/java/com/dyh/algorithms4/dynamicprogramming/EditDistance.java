package com.dyh.algorithms4.dynamicprogramming;

/**
 * @author: dengyunhui
 * @datetime: 2022/2/9 下午5:42
 * @description:
 */
public class EditDistance {

    public static int min(int x, int y, int z) {
        if (x < y && x < z) return x;
        if (y < x && y < z) return y;

        return z;
    }

    public static int editDist(String a, String b) {
        int m = a.length();
        int n = b.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String args[]) {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(editDist(str1, str2));
    }

}
