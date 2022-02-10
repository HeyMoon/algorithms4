package com.dyh.algorithms4.dynamicprogramming;

/**
 * @author: dengyunhui
 * @datetime: 2022/2/7 下午10:01
 * @description: longest common subsequence problem,最长公共子序列
 */
public class LCS {

    private static int[][] lcs(String a, String b) {
        int m = a.length();
        int n = b.length();

        int[][] C = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            C[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            C[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                } else {
                    C[i][j] = Math.max(C[i][j - 1], C[i - 1][j]);
                }
            }
        }

        return C;
    }

    private static String backtrack(int[][] C, char[] a, char[] b, int x, int y) {
        if (x == 0 || y == 0) {
            return "";
        }

        if (a[x - 1] == b[y - 1]) {
            return backtrack(C, a, b, x - 1, y - 1) + a[x - 1];
        }

        if (C[x][y - 1] > C[x - 1][y]) {
            return backtrack(C, a, b, x, y - 1);
        }

        return backtrack(C, a, b, x - 1, y);
    }

    /**
     * LCS 的长度
     *
     * @param a
     * @param b
     * @return
     */
    public static int lcsLength(String a, String b) {
        int[][] c = lcs(a, b);
        return c[a.length()][b.length()];
    }

    /**
     * 读取一个 LCS
     *
     * @param a
     * @param b
     * @return
     */
    public static String printLcs(String a, String b) {
        int[][] c = lcs(a, b);
        return backtrack(c, a.toCharArray(), b.toCharArray(), a.length(), b.length());
    }

    public static void printDiff(int[][] C, char[] a, char[] b, int i, int j) {
        if (i >= 0 && j >= 0 && a[i] == b[j]) {
            printDiff(C, a, b, i - 1, j - 1);
            System.out.println("  " + a[i]);
        } else if (j > 0 && (i == 0 || C[i][j - 1] >= C[i - 1][j])) {
            printDiff(C, a, b, i, j - 1);
            System.out.println("+  " + b[j]);
        } else if (i > 0 && (j == 0 || C[i][j - 1] < C[i - 1][j])) {
            printDiff(C, a, b, i - 1, j);
            System.out.println("-  " + a[i]);
        } else {
            System.out.println();
        }
    }

    public static void printDiff(String a, String b) {
        int[][] c = lcs(a, b);
        printDiff(c, a.toCharArray(), b.toCharArray(), a.length() - 1, b.length() - 1);
    }


    public static void main(String[] args) {
        System.out.println(LCS.lcsLength("AGGTAB", "GXTXAYB"));
        System.out.println(LCS.printLcs("AGGTAB", "GXTXAYB"));
        LCS.printDiff("ABC", "BCDE");
    }

}
