package com.dyh.algorithms4.chapter2;

/**
 * author: dengyunhui
 * datetime: 2021/6/30 21:26
 * <p>
 * 自顶向下的归并排序
 * <p>
 * 有以下优化点：
 * 1. 对小规模子数组使用插入排序。
 * <p>
 * 2. 测试数组是否有序。
 * 在递归的 sort 方法中，如果 a[mid] < a[mid + 1],我们可以认为数组已经是有序的并跳过 merge() 方法。
 * 因为子数组是有序的，如果前半子数组的最大值都比后半子数组的最小值还小，那么就不需要 merge 了
 * <p>
 * 3.不将元素复制到辅助数组
 * 可以节省将数组元素复制到用于归并的辅助数组所用的时间（但空间不行）。
 * 要做到这一点我们要调用两种排序方法，一种将数据从输入数组排序到辅助数组，
 * 一种将数据从辅助数组排序到输入数组
 */
public class Merge {

    public static void sort(Comparable[] a) {
        int low = 0;
        int high = a.length - 1;
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, low, high);

    }

    private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(a, aux, low, mid);
        sort(a, aux, mid + 1, high);
        merge(a, aux, low, mid, high);
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
