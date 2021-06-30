package com.dyh.algorithms4.chapter1.exercise;

import java.util.Arrays;

public class ThreeSumFast {

    public static int count(int[] a) {
        Arrays.sort(a);
        int cnt = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (BinarySearch.rank(a, -(a[i] + a[j])) > j) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

}
