package com.dyh.algorithms4.chapter2.exercise2_3;

import com.dyh.algorithms4.chapter2.Example;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/7 20:48
 * @description: 2.3.22 快速三向切分
 */
public class QuickBentleyMcIlroy {

    // threshold to insertion sort  使用三向切分的阈值
    private static final int INSERTION_SORT_THRESHOLD = 8;

    // threshold to median of 3 partitioning  使用三取样的阈值
    private static final int MEDIAN_OF_3_THRESHOLD = 40;

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        int n = high - low + 1;
        if (n <= INSERTION_SORT_THRESHOLD) {
            insertionSort(a, low, high);
            return;
        } else if (n <= MEDIAN_OF_3_THRESHOLD) {
            //使用三取样切分
            int m = median3(a, low, low + n / 2, high);
            Example.exch(a, m, low);
        } else {
            // use Tukey ninther as partitioning element
            int eps = n / 8;
            int mid = low + n / 2;
            int m1 = median3(a, low, low + eps, low + eps + eps);
            int m2 = median3(a, mid - eps, mid, mid + eps);
            int m3 = median3(a, high - eps - eps, high - eps, high);
            int ninther = median3(a, m1, m2, m3);
            Example.exch(a, ninther, low);
        }

        // Bentley-McIlroy 3-way partitioning
        int i = low, j = high + 1;
        int p = low, q = high + 1;
        Comparable v = a[low];
        while (true) {
            while (Example.less(a[++i], v))
                if (i == high) break;
            while (Example.less(v, a[--j]))
                if (j == low) break;

            // pointers cross
            if (i == j && eq(a[i], v))
                Example.exch(a, ++p, i);
            if (i >= j) break;

            Example.exch(a, i, j);
            if (eq(a[i], v)) Example.exch(a, ++p, i);
            if (eq(a[j], v)) Example.exch(a, --q, j);
        }


        i = j + 1;
        for (int k = low; k <= p; k++)
            Example.exch(a, k, j--);
        for (int k = high; k >= q; k--)
            Example.exch(a, k, i++);

        sort(a, low, j);
        sort(a, i, high);
    }

    private static boolean eq(Comparable comparable, Comparable v) {
        return comparable.compareTo(v) == 0;
    }

    /**
     * find median between i,j,k
     *
     * @param a
     * @param i
     * @param j
     * @param k
     * @return the index of the median element among a[i], a[j], and a[k]
     */
    private static int median3(Comparable[] a, int i, int j, int k) {
        return Example.less(a[i], a[j])
                ? (Example.less(a[j], a[k]) ? j : (Example.less(a[i], a[k]) ? k : i))
                : (Example.less(a[k], a[j]) ? j : (Example.less(a[k], a[i]) ? k : i));
    }

    private static void insertionSort(Comparable[] a, int low, int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low; j--) {
                if (Example.less(a[j], a[j - 1])) {
                    Example.exch(a, j, j - 1);
                }
            }
        }
    }


}
