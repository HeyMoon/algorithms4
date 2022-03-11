package com.dyh.algorithms4.blind75.dp;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/8 下午8:55
 * @description:
 */
public class CoinChange {

    /**
     * https://leetcode-cn.com/problems/coin-change/
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount];
        return coinChange(coins, amount, dp);
    }

    private int coinChange(int[] coins, int amount, int[] count) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }

        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;

        return count[amount - 1];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
    }

}
