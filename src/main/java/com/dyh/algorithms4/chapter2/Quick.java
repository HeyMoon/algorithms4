package com.dyh.algorithms4.chapter2;

import com.dyh.algorithms4.StdRandom;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/1 21:37
 * @description:
 */
public class Quick {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }

        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        //将数组切分为 a[low, i-1],a[i], a[i+1,high]
        int i = low, j = high + 1; //左右扫描指针
        Comparable v = a[low]; // 切分元素

        while (true) {
            //扫描左右，检查扫描是否结束并交换元素
            // v 应该要大于左边的元素，如果扫描到比 v 小的，则停止
            while (Example.less(a[++i], v)) {
                if (i == high) break;
            }

            // v 应该小于右边的元素，如果扫描到比 v 大的，则停止
            while (Example.less(v, a[--j])) {
                if (j == low) break;
            }


            if (i >= j) break;

            Example.exch(a, i, j); //交换 i，j 的位置
        }

        Example.exch(a, low, j); // a[low, j-1] <= a[j] <= a[j+1, high] 达成
        return j;
    }

}
