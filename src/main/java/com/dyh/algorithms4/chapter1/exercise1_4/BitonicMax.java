package com.dyh.algorithms4.chapter1.exercise1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 双调数组：如果一个数组中的所有元素是先递增或递减的，则称这个数组为双调
 */
public class BitonicMax {

    // create a bitonic array of size N
    public static int[] bitonic(int N) {
        int mid = StdRandom.uniform(N);
        int[] a = new int[N];
        for (int i = 1; i < mid; i++) {
            a[i] = a[i - 1] + 1 + StdRandom.uniform(9);
        }

        if (mid > 0) a[mid] = a[mid - 1] + StdRandom.uniform(10) - 5;

        for (int i = mid + 1; i < N; i++) {
            a[i] = a[i - 1] - 1 - StdRandom.uniform(9);
        }

        for (int i = 0; i < N; i++) {
            StdOut.print(a[i]);
            StdOut.print(",");
        }
        StdOut.println("");
        return a;
    }


    /**
     * 返回双调数组中最大的那个数的下标
     *
     * @param a
     * @return
     */
    public static int max(int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (high >= low) {
            if (high == low) {
                return high;
            }

            int mid = low + (high - low) / 2;

            if (a[mid + 1] > a[mid]) {
                low = mid + 1;
            } else if (a[mid + 1] < a[mid]) {
                high = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 10;
        int[] a = bitonic(N);
        StdOut.println("max = " + a[max(a)]);

        int[] a2 = new int[]{0,-5,-11,-13,-19,-26,-32,-34,-40,-48};
        StdOut.println("max = " + a2[max(a2)]);
    }
}
