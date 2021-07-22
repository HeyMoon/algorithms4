package com.dyh.algorithms4.chapter5;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/22 21:18
 * @description:
 */
public class KMP {

    private final int R;
    private final int m;
    private int[][] dfa;

    public KMP(String pat) {
        this.R = 256;
        this.m = pat.length();

        // build DFA from pattern
        dfa = new int[R][m];
        dfa[pat.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];     // Copy mismatch cases. 复制失败情况下的值
            }

            dfa[pat.charAt(j)][j] = j + 1;   // Set match case. 设置匹配成功情况下的值
            x = dfa[pat.charAt(j)][x];     // Update restart state.  更新重启状态
        }
    }

    public int search(String txt) {
        // simulate operation of DFA on text
        int n = txt.length();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == m) return i - m;    // found
        return n;                    // not found
    }

    public static void main(String[] args) {
        KMP kmp = new KMP("AABAAA");
        System.out.println(kmp.search("ABAAAABAAAAAAAAA"));

    }


}
