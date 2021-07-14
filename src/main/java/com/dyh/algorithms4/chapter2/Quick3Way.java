package com.dyh.algorithms4.chapter2;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/1 22:11
 * @description:
 */
public class Quick3Way {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * a[low, lt -1] 的元素都小于 v
     * a[lt, i - 1] 的元素等于 v
     * a[i, gt] 中的元素不确定
     * a[gt + 1, high] 的元素都大于 v
     *
     * @param a
     * @param low
     * @param high
     */
    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }

        int lt = low, gt = high, i = low + 1;
        Comparable v = a[low];

        /**
         * a[i] < v 将 a[lt] 和 a[i] 交换，将 lt 和 i 加 1;
         * a[i] > v 将 a[gt] 和 a[i] 交换，将 gt 减 1;
         * a[i] == v 将 i 加 1
         */
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                //a[i] < v
                Example.exch(a, lt++, i++);
            } else if (cmp > 0) {
                Example.exch(a, i, gt--);
            } else {
                i++;
            }
        }

        sort(a, low, lt - 1);
        sort(a, gt + 1, high);
    }

}
