package com.dyh.algorithms4.leetcode.lc_2023_2;

/**
 * @author: dengyunhui
 * @datetime: 2023/1/30 上午9:58
 * @description:
 */
public class MinimumSizeSubarraySum {


    public static void main(String[] args) {


    }

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int length = 0;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                length = length == 0 ? j - i + 1 : Math.min(length, j - i + 1);
                sum -= nums[i++];
            }
        }

        return length;
    }
}
