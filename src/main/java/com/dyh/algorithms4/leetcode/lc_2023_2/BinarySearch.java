package com.dyh.algorithms4.leetcode.lc_2023_2;

/**
 * @author: dengyunhui
 * @datetime: 2023/1/29 下午3:19
 * @description: https://leetcode.cn/problems/binary-search/
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};

        System.out.print(binarySearch.search2(nums, 9));

    }

    /**
     * 左闭右闭即 [low, high]
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 左闭右开即 [low, high)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }


}
