package com.dyh.algorithms4.chapter2.exercise2_5;

import com.dyh.algorithms4.chapter2.Quick;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/7 21:18
 * @description:
 */
public class E_2_5_2 {

    public static void findCombineWords(String[] a) {
        Quick.sort(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                String combine = a[i] + a[j];
                int k = Collections.binarySearch(Arrays.asList(a), combine, Comparator.naturalOrder());
                if (k > -1) {
                    System.out.println(a[k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"after", "thought", "afterthought", "a", "b", "ab", "c", "d", "bc"};
        findCombineWords(strings);
    }
}
