package com.dyh.algorithms4.blind75.dp;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/8 下午9:18
 * @description:
 */
public class LongestIncreasingSubsequence {

    /**
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }

            }
        }

        int max = 0;
        for (int i : lis) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

}
