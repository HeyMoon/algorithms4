package com.dyh.algorithms4.chapter5;

import com.dyh.algorithms4.chapter2.Example;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/21 21:26
 * @description:
 */
public class Quick3String {

    private static int charAt(String a, int d) {
        if (d < a.length()) {
            return a.charAt(d);
        }

        return -1;
    }

    public static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo) {
            return;
        }

        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v) {
                Example.exch(a, lt++, i++);
            } else if (t > v) {
                Example.exch(a, i, gt--);
            } else {
                i++;
            }
        }

        sort(a, lo, lt - 1, d);

        if (v >= 0) {
            sort(a, lt, gt, d + 1);
        }

        sort(a, gt + 1, hi, d);
    }

}
