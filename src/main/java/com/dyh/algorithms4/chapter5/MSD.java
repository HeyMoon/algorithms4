package com.dyh.algorithms4.chapter5;

import com.dyh.algorithms4.chapter2.Insertion;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/21 20:55
 * @description: 高位优先的字符串排序
 */
public class MSD {

    private static final int BITS_PER_BYTE = 8;
    private static final int BITS_PER_INT = 32;   // each Java int is 32 bits
    private static final int CUTOFF = 15;   // cutoff to insertion sort

    private static int R = 256; // 基数
    private static final int M = 15; // 小数组切换阈值
    private static String[] aux;


    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        }

        return -1;
    }

    public static void sort(String[] a) {
        int n = a.length;
        aux = new String[n];
        sort(a, 0, n - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        // 以第 d 个字符为键将 a[lo] 至 a[hi] 排序
        if (hi <= lo + M) {
            Insertion.sort(a, lo, hi);
            return;
        }

        // 计算频率
        int[] count = new int[R + 2];

        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }

        // 频率转换为索引
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }

        // 数据分类
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        // 回写
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }

        // 递归的以每个字符为键进行排序
        for (int i = 0; i < R; i++) {
            sort(a, lo + count[i], lo + count[i + 1] - 1, d + 1);
        }

    }

    /**
     * Rearranges the array of 32-bit integers in ascending order.
     * Currently assumes that the integers are nonnegative.
     *
     * @param a the array to be sorted
     */
    public static void sort(int[] a) {
        int n = a.length;
        int[] aux = new int[n];
        sort(a, 0, n - 1, 0, aux);
    }

    // MSD sort from a[lo] to a[hi], starting at the dth byte
    private static void sort(int[] a, int lo, int hi, int d, int[] aux) {

        // cutoff to insertion sort for small subarrays
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi);
            return;
        }

        // compute frequency counts (need R = 256)
        int[] count = new int[R + 1];
        int mask = R - 1;   // 0xFF;
        int shift = BITS_PER_INT - BITS_PER_BYTE * d - BITS_PER_BYTE;
        for (int i = lo; i <= hi; i++) {
            int c = (a[i] >> shift) & mask;
            count[c + 1]++;
        }

        // transform counts to indicies
        for (int r = 0; r < R; r++)
            count[r + 1] += count[r];

        // for most significant byte, 0x80-0xFF comes before 0x00-0x7F
        if (d == 0) {
            int shift1 = count[R] - count[R / 2];
            int shift2 = count[R / 2];
            count[R] = shift1 + count[1];   // to simplify recursive calls later
            for (int r = 0; r < R / 2; r++)
                count[r] += shift1;
            for (int r = R / 2; r < R; r++)
                count[r] -= shift2;
        }

        // distribute
        for (int i = lo; i <= hi; i++) {
            int c = (a[i] >> shift) & mask;
            aux[count[c]++] = a[i];
        }

        // copy back
        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];

        // no more bits
        if (d == 3) return;

        // special case for most significant byte
        if (d == 0 && count[R / 2] > 0)
            sort(a, lo, lo + count[R / 2] - 1, d + 1, aux);

        // special case for other bytes
        if (d != 0 && count[0] > 0)
            sort(a, lo, lo + count[0] - 1, d + 1, aux);

        // recursively sort for each character
        // (could skip r = R/2 for d = 0 and skip r = R for d > 0)
        for (int r = 0; r < R; r++)
            if (count[r + 1] > count[r])
                sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1, aux);
    }

    // insertion sort a[lo..hi]
    private static void insertion(int[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && a[j] < a[j - 1]; j--)
                exch(a, j, j - 1);
    }

    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
