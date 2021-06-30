package com.dyh.algorithms4.chapter1.exercise1_4;

import com.dyh.algorithms4.chapter1.exercise.BinarySearch;

import java.util.Arrays;

public class TwoSumFaster {

    public static void count(int[] a) {
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int r = a[i];
            if (BinarySearch.rank2(a, -r) > i) {
                count++;
            }
        }
        System.out.println("count: " + count);
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, 2, 3, 1, 4, 5, 6, -3};
        count(a);
    }
}
