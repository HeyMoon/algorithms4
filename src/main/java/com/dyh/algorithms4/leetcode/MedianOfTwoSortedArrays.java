package com.dyh.algorithms4.leetcode;

/**
 * @author: dengyunhui
 * @datetime: 2021/8/18 21:40
 * @description: 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0.0;
        }

        int[] merge = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        while (true) {
            if (i >= nums1.length) {
                merge[i + j] = nums2[j++];
            } else if (j >= nums2.length) {
                merge[i + j] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                merge[i + j] = nums1[i++];
            } else {
                merge[i + j] = nums2[j++];
            }

            if (i >= nums1.length && j >= nums2.length) {
                break;
            }
        }

        if (merge.length % 2 == 0) {
            return (merge[merge.length / 2] + merge[merge.length / 2 - 1]) / 2.0;
        } else {
            return merge[merge.length / 2];
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        double median = medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0});
        System.out.println(median);
    }
}
