package com.dyh.algorithms4.chapter1.exercise1_4;

import com.dyh.algorithms4.chapter1.exercise.BinarySearch;

/**
 * 双调查找。如果一个数组中的所有元素都是先递增后递减的，则称这个数组为双调。
 * 给定一个包含 N 个 不同 int 值的双调数组，判断他是否含有给定的整数。
 * 程序在最坏情况下的比较次数为 ~ 3 lgN
 */
public class BitonicSearch {

    /**
     * 先找到双调数组中最大数的下标，比较 search 和最大数的大小。然后再在两边二分查找
     *
     * @param a
     * @param search
     * @return 如果含有给定数，则返回给定数的下标。否则返回 -1
     */
    public static int contains(int[] a, int search) {
        int i = BitonicMax.max(a);
        int max = a[i];
        if (max == search) {
            return i;
        } else if (max > search) {
            //分别在两边二分查找
            int left = BinarySearch.binarySearch(a, 0, i - 1, search);
            if (left > -1) {
                return left;
            } else {
                return BinarySearch.binarySearch(a, i + 1, a.length - 1, search);
            }
        } else {
            // search 大于 最大数，返回 -1
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] a = BitonicMax.bitonic(10);
        int search = a[5];
        System.out.println("search key:" + search);
        System.out.println(contains(a, search));

        int[] a2 = BitonicMax.bitonic(10);
        int search2 = a2[6] * 2;
        System.out.println("search key:" + search2);
        System.out.println(contains(a2, search2));
    }


}
