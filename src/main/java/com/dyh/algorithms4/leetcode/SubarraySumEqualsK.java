package com.dyh.algorithms4.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengyunhui
 * @datetime: 2022/2/19 上午12:29
 * @description:
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
