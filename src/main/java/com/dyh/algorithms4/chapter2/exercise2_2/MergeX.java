package com.dyh.algorithms4.chapter2.exercise2_2;

import com.dyh.algorithms4.chapter2.Example;

/**
 * @author: dengyunhui
 * @datetime: 2021/6/30 22:09
 * @description: 2.2.11 对归并排序进行改进
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
public class MergeX {

    public static final int THRESHOLD = 7; // 小数组的阈值

    public static void sort(Comparable[] a) {
        int low = 0;
        int high = a.length - 1;
        Comparable[] aux = a.clone();
        sort(aux, a, low, high);

    }

    private static void sort(Comparable[] src, Comparable[] dest, int low, int high) {
        if (high <= low + THRESHOLD) {
            insertionSort(dest, low, high);
            return;
        }

        int mid = low + (high - low) / 2;
        sort(dest, src, low, mid);
        sort(dest, src, mid + 1, high);

        //测试数组是否有序
        if (Example.less(src[mid], src[mid + 1])) {
            System.arraycopy(src, low, dest, low, high - low + 1);
            return;
        }

        merge(src, dest, low, mid, high);
    }

    private static void merge(Comparable[] src, Comparable[] dest, int low, int mid, int high) {
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                dest[k] = src[j++];
            } else if (j > high) {
                dest[k] = src[i++];
            } else if (Example.less(src[i], src[j])) {
                dest[k] = src[i++];
            } else {
                dest[k] = src[j++];
            }
        }

    }

    /**
     * 使用插入排序对小规模数组进行优化
     *
     * @param dest
     * @param low
     * @param high
     */
    private static void insertionSort(Comparable[] dest, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            for (int j = i; j > low; j--) {
                if (Example.less(dest[j], dest[j - 1])) {
                    Example.exch(dest, j, j - 1);
                }
            }
        }
    }

}
