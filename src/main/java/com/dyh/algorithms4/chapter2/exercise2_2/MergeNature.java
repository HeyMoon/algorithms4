package com.dyh.algorithms4.chapter2.exercise2_2;

import com.dyh.algorithms4.chapter2.Example;
import com.dyh.algorithms4.chapter2.MergeBU;


/**
 * @author: dengyunhui
 * @datetime: 2021/7/1 01:03
 * @description: 2.2.16 自然的归并排序
 */
public class MergeNature {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];

        int low = 0;
        int mid = findSortedArray(a, low);
        while (true) {
            int high = findSortedArray(a, mid + 1);
            MergeBU.merge(a, aux, low, mid, high);
            if (high >= a.length - 1) {
                break;
            }
            mid = high;
        }
    }

    private static int findSortedArray(Comparable[] a, int low) {
        for (int i = low + 1; i < a.length; i++) {
            if (Example.less(a[i], a[i - 1])) {
                return i - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        sort(strings);
        System.out.println(String.join(",", strings));
    }

}
