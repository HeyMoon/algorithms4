package com.dyh.algorithms4.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: dengyunhui
 * @datetime: 2022/2/18 下午9:20
 * @description: 剑指 Offer II 007. 数组中和为 0 的三个数
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(threeSum.threeSum(null));
        System.out.println(threeSum.threeSum(new int[]{0}));
    }

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/1fGaJU
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList();
        }

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> r = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > 0) {
                break;
            }

            int one = nums[i];

            int j = i + 1;
            int h = n - 1;
            while (j < h) {
                if (nums[j] + nums[h] + one == 0) {
                    r.add(Arrays.asList(one, nums[j], nums[h]));
                    while (j < h && nums[j] == nums[++j]) ;
                    while (j < h && nums[h] == nums[--h]) ;
                } else if (nums[j] + nums[h] + one > 0) {
                    h--;
                } else {
                    j++;
                }
            }
        }

        return r;
    }
}
