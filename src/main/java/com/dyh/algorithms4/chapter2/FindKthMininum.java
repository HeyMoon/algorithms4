package com.dyh.algorithms4.chapter2;

import com.dyh.algorithms4.StdRandom;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/7 21:56
 * @description: 2.5.6
 */
public class FindKthMininum {

    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int low = 0, hi = a.length - 1;
        while (hi > low) {
            int j = partition(a, low, hi);
            if (j == k) break;
            else if (j > k) hi = j - 1;
            else if (j < k) low = j + 1;
        }

        return a[k];
    }

    public static Comparable selectWithRecursion(Comparable[] a, int k) {
        StdRandom.shuffle(a);

        selectWithRecursion(a, 0, a.length - 1, k);
        return a[k];
    }

    private static void selectWithRecursion(Comparable[] a, int low, int high, int k) {
        if (low < high) {
            return;
        }
        int j = partition(a, low, high);
        if (j == k) {
            return;
        } else if (j > k) {
            selectWithRecursion(a, low, j - 1, k);
        } else {
            selectWithRecursion(a, j + 1, high, k);
        }
    }

    private static int partition(Comparable[] a, int low, int hi) {
        int lt = low, gt = hi + 1;
        Comparable v = a[low];

        while (true) {
            while (Example.less(a[++lt], v)) {
                if (lt == hi) {
                    break;
                }
            }

            while (Example.less(v, a[--gt])) {
                if (gt == low) {
                    break;
                }
            }

            if (lt >= gt) {
                break;
            }

            Example.exch(a, lt, gt);
        }

        Example.exch(a, low, gt);
        return gt;
    }

}
