package com.dyh.algorithms4.chapter2;

import com.dyh.algorithms4.StdOut;

/**
 * author: dengyunhui
 * datetime: 2021/6/28 22:59
 */
public class Example {

    public static void sort(Comparable[] a) {

    }

    /**
     * 比较大小
     *
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组中 i,j 位置的值
     *
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] a = new String[]{};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
