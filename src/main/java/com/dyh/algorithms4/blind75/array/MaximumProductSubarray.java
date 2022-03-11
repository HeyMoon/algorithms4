package com.dyh.algorithms4.blind75.array;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/8 上午10:41
 * @description:
 */
public class MaximumProductSubarray {

    /**
     * https://leetcode-cn.com/problems/maximum-product-subarray/
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int maxF = nums[0];
        int minF = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int mx = maxF, min = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], min * nums[i]));
            minF = Math.min(min * nums[i], Math.min(nums[i], mx * nums[i]));
            max = Math.max(maxF, max);
        }

        return max;
    }


    public static void main(String[] args) {
        MaximumProductSubarray subarray = new MaximumProductSubarray();
        System.out.println(subarray.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(subarray.maxProduct(new int[]{-2, 0, -1}));

    }
}
