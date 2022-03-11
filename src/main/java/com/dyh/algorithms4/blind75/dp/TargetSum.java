package com.dyh.algorithms4.blind75.dp;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/10 下午8:38
 * @description: https://leetcode-cn.com/problems/target-sum/description/
 */
public class TargetSum {


    public int findTargetSumWays(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        TargetSum sum = new TargetSum();
        System.out.println(sum.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));

    }

}
