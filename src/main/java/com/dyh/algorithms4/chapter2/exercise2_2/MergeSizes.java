package com.dyh.algorithms4.chapter2.exercise2_2;

/**
 * @author: dengyunhui
 * @datetime: 2021/6/30 21:54
 * @description: 2.6 编写一个程序来计算自顶向下和自底向上的归并排序访问数组的准确次数
 */
public class MergeSizes {
    public static void topDownMergesort(Comparable[] a) {
        int low = 0;
        int high = a.length - 1;
        Comparable[] aux = new Comparable[a.length];
        topDownSort(a, aux, low, high);

    }

    public static void bottomUpMergesort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];

        for (int size = 1; size < n; size = size + size) {
            for (int low = 0; low < n - size; low = low + size + size) {
                merge(a, aux, low, low + size - 1, Math.min(low + size + size - 1, n - 1));
            }
        }

    }

    private static void topDownSort(Comparable[] a, Comparable[] aux, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        topDownSort(a, aux, low, mid);
        topDownSort(a, aux, mid + 1, high);
        merge(a, aux, low, mid, high);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        System.out.print(high - low + 1);
        System.out.print(" ");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 512; i++) {
            String[] a = new String[i];
            MergeSizes.topDownMergesort(a);
            System.out.println();
            MergeSizes.bottomUpMergesort(a);
            System.out.println();
        }
    }

}
