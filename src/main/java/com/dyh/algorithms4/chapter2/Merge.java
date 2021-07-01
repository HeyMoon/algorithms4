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


    public static int[] indexSort(Comparable[] a) {
        int[] index = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            index[i] = i;
        }

        int[] aux = new int[index.length];

        indexSort(a, index, aux, 0, a.length - 1);
        return index;
    }

    private static void indexSort(Comparable[] a, int[] index, int[] aux, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        indexSort(a, index, aux, low, mid);
        indexSort(a, index, aux, mid + 1, high);
        indexMerge(a, index, aux, low, mid, high);
    }

    private static void indexMerge(Comparable[] a, int[] index, int[] aux, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            aux[i] = index[i];
        }

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                index[k] = aux[j++];
            } else if (j > high) {
                index[k] = aux[i++];
            } else if (Example.less(a[aux[i]], a[aux[j]])) {
                index[k] = aux[i++];
            } else {
                index[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        int[] index = indexSort(a);

        String[] a2 = a.clone();
        System.out.println("a:" + String.join(",", a));
        System.out.println("a2:" + String.join(",", a2));
        for (int i = 0; i < index.length; i++) {
            assert a[index[i]].equals(a2[i]);
        }
    }

}
