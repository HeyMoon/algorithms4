package com.dyh.algorithms4.blind75.dp;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/10 下午8:30
 * @description: https://leetcode-cn.com/problems/combination-sum-iv/
 */
public class CombinationSum4 {

    /**
     * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
     * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
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
        CombinationSum4 combinationSum4 = new CombinationSum4();

        System.out.println(combinationSum4.combinationSum4(new int[]{1, 2, 3}, 4));
    }

}
