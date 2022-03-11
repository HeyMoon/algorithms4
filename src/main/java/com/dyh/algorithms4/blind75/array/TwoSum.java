package com.dyh.algorithms4.blind75.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/5 下午12:21
 * @description:
 */
public class TwoSum {

    /**
     * https://leetcode-cn.com/problems/two-sum/
     * <p>
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];

            if (map.containsKey(target - k)) {
                result[0] = i;
                result[1] = map.get(target - k);
                break;
            } else {
                map.put(k, i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }



}
