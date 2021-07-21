package com.dyh.algorithms4.chapter5;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/20 23:09
 * @description: 低位优先的字符串排序
 */
public class LSD {

    private static final int BITS_PER_BYTE = 8;

    /**
     * @param a
     * @param w 字符串中字符的个数
     */
    public static void sort(String[] a, int w) {
        int n = a.length;
        int r = 256;
        String[] aux = new String[n];
        for (int i = w - 1; i >= 0; i--) {
            // 根据第 d 个字符用键索引计数法排序

            int[] count = new int[r + 1]; // 计算出现的频率
            for (int j = 0; j < n; j++) {
                count[a[j].charAt(i) + 1]++;
            }

            for (int j = 0; j < r; j++) {  // 将频率转换为索引
                count[r + 1] += count[r];
            }

            for (int j = 0; j < n; j++) {  // 将元素分类
                aux[count[a[j].charAt(i)]++] = a[j];
            }

            for (int j = 0; j < n; j++) { // 回写
                a[i] = aux[i];
            }
        }

    }

    /**
     * Rearranges the array of 32-bit integers in ascending order.
     * This is about 2-3x faster than Arrays.sort().
     *
     * @param a
     */
    public static void sort(int[] a) {
        final int BITS = 32;                 // each int is 32 bits
        final int R = 1 << BITS_PER_BYTE;    // each bytes is between 0 and 255
        final int MASK = R - 1;              // 0xFF
        final int w = BITS / BITS_PER_BYTE;  // each int is 4 bytes

        int n = a.length;
        int[] aux = new int[n];

        for (int d = 0; d < w; d++) {

            // compute frequency counts
            int[] count = new int[R + 1];
            for (int i = 0; i < n; i++) {
                int c = (a[i] >> BITS_PER_BYTE * d) & MASK;
                count[c + 1]++;
            }

            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];

            // for most significant byte, 0x80-0xFF comes before 0x00-0x7F
            if (d == w - 1) {
                int shift1 = count[R] - count[R / 2];
                int shift2 = count[R / 2];
                for (int r = 0; r < R / 2; r++)
                    count[r] += shift1;
                for (int r = R / 2; r < R; r++)
                    count[r] -= shift2;
            }

            // move data
            for (int i = 0; i < n; i++) {
                int c = (a[i] >> BITS_PER_BYTE * d) & MASK;
                aux[count[c]++] = a[i];
            }

            // copy back
            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }


    }

}
