package com.dyh.algorithms4.blind75.array;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/8 上午9:42
 * @description:
 */
public class MaximumSubarray {


    /**
     * https://leetcode-cn.com/problems/maximum-subarray/
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = 0;

        for (int i = 0; i < nums.length; i++) {
            if (pre > 0) {
                pre = pre + nums[i];
            } else {
                pre = nums[i];
            }

            max = Math.max(max, pre);
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray subarray = new MaximumSubarray();
        System.out.println(subarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        System.out.println(subarray.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

}
