package com.dyh.algorithms4.chapter2.exercise2_2;

import com.dyh.algorithms4.chapter2.Example;

/**
 * @author: dengyunhui
 * @datetime: 2021/6/30 22:01
 * @description: 2.2.10 快速归并
 */
public class FastMerge {

    public static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        for (int i = low; i <= mid; i++) {
            aux[i] = a[i];
        }

        for (int i = mid + 1; i <= high; i++) {
            aux[i] = a[mid + 1 + high - i];
        }

        int i = low, j = high;
        for (int k = low; k <= high; k++) {
            if (Example.less(a[i], a[j])) {
                a[k] = a[i++];
            } else {
                a[k] = a[j--];
            }
        }
    }

}
