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

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0.0;
        }

        int length = nums1.length + nums2.length;
        int i1 = 0;
        int i2 = 0;
        if (length % 2 == 0) {
            i1 = length / 2 - 1;
            i2 = length / 2;
        } else {
            i1 = length / 2;
            i2 = length / 2;
        }

        int i = 0, j = 0;
        int index = 0;
        int[] result = new int[2];
        while (true) {
            index = i + j;
            if (i >= nums1.length) {
                if (index == i1) {
                    result[0] = nums2[j];
                } else if (index == i2) {
                    result[1] = nums2[j];
                    break;
                }
                j++;
            } else if (j >= nums2.length) {
                if (index == i1) {
                    result[0] = nums1[i];
                } else if (index == i2) {
                    result[1] = nums1[i];
                    break;
                }
                i++;
            } else if (nums1[i] < nums2[j]) {
                if (index == i1) {
                    result[0] = nums1[i];
                } else if (index == i2) {
                    result[1] = nums1[i];
                    break;
                }
                i++;
            } else {
                if (index == i1) {
                    result[0] = nums2[j];
                } else if (index == i2) {
                    result[1] = nums2[j];
                    break;
                }
                j++;
            }

            if (i >= nums1.length && j >= nums2.length) {
                break;
            }
        }

        return length % 2 == 0 ? (result[0] + result[1]) / 2.0 : result[0];
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        double median = medianOfTwoSortedArrays.findMedianSortedArrays2(new int[]{1, 3}, new int[]{2});
        System.out.println(median);
    }
}
