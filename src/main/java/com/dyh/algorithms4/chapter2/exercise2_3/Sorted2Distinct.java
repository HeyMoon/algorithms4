package com.dyh.algorithms4.chapter2.exercise2_3;

import com.dyh.algorithms4.chapter2.Example;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/6 21:39
 * @description:
 */
public class Sorted2Distinct {

    public static void sort(Comparable[] a) {
        int lt = 0, gt = a.length - 1;
        int i = 0;
        while (i <= gt) {
            int cmp = a[i].compareTo(a[lt]);
            if (cmp < 0) {
                Example.exch(a, i++, lt++);
            } else if (cmp > 0) {
                Example.exch(a, i, gt--);
            } else {
                i++;
            }
        }
    }
}
