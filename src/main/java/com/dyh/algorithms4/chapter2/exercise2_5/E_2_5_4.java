package com.dyh.algorithms4.chapter2.exercise2_5;

import com.dyh.algorithms4.chapter2.Quick;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/7 21:45
 * @description:
 */
public class E_2_5_4 {


    public static String[] dedup(String[] a) {
        Quick.sort(a);
        String[] a2 = null;
        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(a[i + 1]) == 0) {
                a2 = new String[a.length - 1];
                System.arraycopy(a, i + 1, a2, 0, a.length - 1);
            }
        }

        return a2;
    }

}
