package com.dyh.algorithms4.chapter5;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/22 21:13
 * @description:
 */
public class Brute {

    public static int search(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                return i;
            }
        }

        return n;
    }


    public static int search2(String pat, String txt) {
        int j, m = pat.length();
        int i, n = txt.length();
        for (i = 0, j = 0; i < n && j < m; i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                i = i - j;
                j = 0;
            }
        }

        if (j == m) {
            return i - m;
        } else {
            return n;
        }
    }


}
