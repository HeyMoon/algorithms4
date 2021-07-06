package com.dyh.algorithms4.chapter2.exercise2_3;

import com.dyh.algorithms4.chapter2.Example;
import com.dyh.algorithms4.chapter2.Insertion;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/6 22:03
 * @description:
 */
public class E_2_3_22 {

    private static final int MEDIAN_OF_3_CUTOFF = 40;

    private static final int INSERTION_SORT_CUTOFF = 8;


    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        int n = hi - lo + 1;
        // 插入排序
        if (n < INSERTION_SORT_CUTOFF) {
            Insertion.sort(a);
            return;
        } else if (n <= MEDIAN_OF_3_CUTOFF) {
            //使用三取样切分
            int m = median3(a, lo, lo + n / 2, hi);
            Example.exch(a, m, lo);
        } else {
            // use Tukey ninther as partitioning element
            int eps = n / 8;
            int mid = lo + n / 2;
            int m1 = median3(a, lo, lo + eps, lo + eps + eps);
            int m2 = median3(a, mid - eps, mid, mid + eps);
            int m3 = median3(a, hi - eps - eps, hi - eps, hi);
            int ninther = median3(a, m1, m2, m3);
            Example.exch(a, ninther, lo);
        }

        // Bentley-McIlroy 3-way partitioning
        int i = lo, j = hi + 1;
        int p = lo, q = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (Example.less(a[++i], v)) {
                if (i == hi) break;
            }

            while (Example.less(v, a[--j])) {
                if (j == lo) break;
            }

            if (i == j && eq(a[i], v)) {
                Example.exch(a, ++p, i);
            }

            if (i >= j) {
                break;
            }

            Example.exch(a, i, j);

            if (eq(a[i], v)) {
                Example.exch(a, ++p, i);
            }

            if (eq(a[j], v)) {
                Example.exch(a, --q, j);
            }
        }
    }

    /**
     * 返回 a[i],a[j],a[k] 三个元素中的中位数
     *
     * @param a
     * @param i
     * @param j
     * @param k
     * @return
     */
    private static int median3(Comparable[] a, int i, int j, int k) {
        return Example.less(a[i], a[j]) ?
                (Example.less(a[j], a[k]) ? j : Example.less(a[i], a[k]) ? k : i) :
                (Example.less(a[k], a[j]) ? j : Example.less(a[k], a[i]) ? k : i);

    }

    private static boolean eq(Comparable comparable, Comparable v) {
        return comparable.compareTo(v) == 0;
    }


}
