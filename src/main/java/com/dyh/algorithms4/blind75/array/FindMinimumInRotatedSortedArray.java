package com.dyh.algorithms4.blind75.array;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/8 上午11:46
 * @description:
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int high = nums.length - 1;
        int low = 0;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray array = new FindMinimumInRotatedSortedArray();
        System.out.println(array.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(array.findMin(new int[]{0, 1, 2, 4, 5, 6, 7}));
        System.out.println(array.findMin(new int[]{3, 4, 5, 1, 2}));
    }

}
