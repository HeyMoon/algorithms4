package com.dyh.algorithms4.blind75.dp;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/11 上午8:42
 * @description: https://leetcode-cn.com/problems/house-robber-ii/
 */
public class HouseRobber2 {


    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int end = n - 1;
        for (int i = 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        int max1 = dp[n - 2];

        int[] dp2 = new int[n];
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);

        end = n;
        for (int i = 3; i < end; i++) {
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }

        int max2 = dp2[n - 1];

        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        HouseRobber2 houseRobber2 = new HouseRobber2();
        System.out.println(houseRobber2.rob(new int[]{1, 2, 3, 1}));
        System.out.println(houseRobber2.rob(new int[]{200, 3, 140, 20, 10}));
    }


}
