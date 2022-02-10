package com.dyh.algorithms4.dynamicprogramming;

/**
 * @author: dengyunhui
 * @datetime: 2022/2/8 下午4:57
 * @description:
 */
public class CoinChange {

    /**
     * 假设零钱有{1,2,3},要将 4 块钱找开。
     *
     * @param sum 需要找零的钱
     * @param s   {1,2,3}
     * @return
     */
    public static int count(int[] s, int m, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = s[i]; j <= sum; j++) {
                dp[j] = dp[j] + dp[j - s[i]];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int arr[] = {5, 2, 3, 6};
        int m = arr.length;
        int n = 10;
        System.out.println(CoinChange.count(arr, m, n));
    }

}
