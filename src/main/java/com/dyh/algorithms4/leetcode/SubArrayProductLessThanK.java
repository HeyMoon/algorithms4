package com.dyh.algorithms4.leetcode;

/**
 * @author: dengyunhui
 * @datetime: 2022/2/18 下午11:59
 * @description:
 */
public class SubArrayProductLessThanK {

    public static void main(String[] args) {
        SubArrayProductLessThanK lessThanK = new SubArrayProductLessThanK();
        System.out.println(lessThanK.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));

    }

    /**
     * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int multiply = 1;
        int count = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            multiply *= nums[right];
            while (multiply >= k && left <= right) {
                multiply = multiply / nums[left++];
            }

            if (left <= right) {
                count += right - left + 1;
            }

        }

        return count;
    }
}
