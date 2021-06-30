package com.dyh.algorithms4.chapter2.exercise2_2;

import com.dyh.algorithms4.chapter2.Example;

/**
 * @author: dengyunhui
 * @datetime: 2021/6/30 22:28
 * @description: 2.2.12 次线性的额外空间
 */
public class E_2_2_12 {

    public static void sort(Comparable[] a, int m) {
        int n = a.length;
        int count = Math.max(m, n / m); // 总共有几块

        for (int i = 0; i < count; i++) {

        }
        for (int i = 0; i < n - 1; i = i + m) {
            sort(a, i, i + m - 1);
        }
    }

    /**
     * 选择排序
     *
     * @param a
     * @param low
     * @param high
     */
    private static void sort(Comparable[] a, int low, int high) {
        for (int i = low; i <= high; i++) {
            int min = i;
            for (int j = i + 1; j <= high; j++) {
                if (Example.less(a[j], a[min])) {
                    min = j;
                }
            }

            Example.exch(a, i, min);
        }
    }

}
