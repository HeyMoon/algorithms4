package com.dyh.algorithms4.blind75.array;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/8 下午3:06
 * @description:
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[low]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray array = new SearchInRotatedSortedArray();
        System.out.println(array.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(array.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));

    }

}
