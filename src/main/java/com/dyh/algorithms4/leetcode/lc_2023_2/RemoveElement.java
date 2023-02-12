package com.dyh.algorithms4.leetcode.lc_2023_2;

/**
 * @author: dengyunhui
 * @datetime: 2023/1/30 上午9:47
 * @description: https://leetcode.cn/problems/remove-element/
 */
public class RemoveElement {

    public static void main(String[] args) {


    }

    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }

        return slowIndex;
    }
}
