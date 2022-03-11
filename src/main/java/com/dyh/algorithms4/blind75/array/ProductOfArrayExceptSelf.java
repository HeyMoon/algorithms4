package com.dyh.algorithms4.blind75.array;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/7 下午9:38
 * @description:
 */
public class ProductOfArrayExceptSelf {

    /**
     * https://leetcode-cn.com/problems/product-of-array-except-self/
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        int[] l = new int[nums.length];
        int[] r = new int[nums.length];

        l[0] = 1;
        r[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = l[i] * r[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf self = new ProductOfArrayExceptSelf();

        System.out.println(self.productExceptSelf(new int[]{1, 2, 3, 4}));

    }
}
