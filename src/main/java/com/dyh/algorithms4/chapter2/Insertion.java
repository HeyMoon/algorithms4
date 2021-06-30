package com.dyh.algorithms4.chapter2;

/**
 * author: dengyunhui
 * datetime: 2021/6/30 21:21
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (Example.less(a[j], a[j - 1])) {
                    Example.exch(a, j, j - 1);
                }
            }
        }
    }
}
