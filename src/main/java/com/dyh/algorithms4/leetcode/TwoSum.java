package com.dyh.algorithms4.leetcode;

/**
 * @author: dengyunhui
 * @datetime: 2022/2/18 下午9:11
 * @description: 剑指 Offer II 006. 排序数组中两个数字之和
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        int[] r = new int[2];
        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                r[0] = i;
                r[1] = j;
                break;
            }
        }

        return r;
    }

}
