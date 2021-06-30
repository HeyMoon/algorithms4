package com.dyh.algorithms4.chapter2;

/**
 * author: dengyunhui
 * datetime: 2021/6/30 21:20
 */
public class Selection {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (Example.less(a[j], a[min])) {
                    min = j;
                }
            }

            Example.exch(a, i, min);
        }
    }

}
