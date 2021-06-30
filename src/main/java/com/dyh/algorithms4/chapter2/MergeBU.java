package com.dyh.algorithms4.chapter2;

/**
 * author: dengyunhui
 * datetime: 2021/6/30 21:34
 * <p>
 * 自底向上的归并排序
 */
public class MergeBU {


    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];

        for (int size = 1; size < n; size = size + size) {
            for (int low = 0; low < n - size; low = low + size + size) {
                merge(a, aux, low, low + size - 1, Math.min(low + size + size - 1, n - 1));
            }
        }

    }

    private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (Example.less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

}
