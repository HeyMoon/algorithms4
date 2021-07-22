package com.dyh.algorithms4.chapter5;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/22 23:17
 * @description:
 */
public class BoyerMoore {

    private int[] right;
    private String pat;

    public BoyerMoore(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];

        for (int i = 0; i < R; i++) {
            right[i] = -1;  // 不包含在模式字符串中的字符的值为 -1
        }

        for (int j = 0; j < M; j++) {
            right[pat.charAt(j)] = j; // 包含在模式中的字符串中字符的值为它在其中出现的最右位置
        }

    }

    public int search(String txt) {
        int N = txt.length();
        int M = pat.length();

        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1) {
                        skip = 1;
                    }
                    break;
                }
            }

            if (skip == 0) {
                return i;
            }
        }

        return N;
    }

    public static void main(String[] args) {
        String pat = "NEEDLE";
        String txt = "FINDINAHAYSTACKNEEDLE";

        BoyerMoore boyerMoore = new BoyerMoore(pat);
        System.out.println(boyerMoore.search(txt));
    }
}
