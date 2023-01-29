package com.dyh.algorithms4.blind75.dp;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/11 下午4:42
 * @description:
 */
public class JumpGame2 {

    public int jump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = 1;

        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + 1);
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        JumpGame2 jumpGame2 = new JumpGame2();
        System.out.println(jumpGame2.jump(new int[]{2, 3, 1, 1, 4}));
    }

}
