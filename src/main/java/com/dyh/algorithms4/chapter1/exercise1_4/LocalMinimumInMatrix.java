package com.dyh.algorithms4.chapter1.exercise1_4;

/**
 * 1.4.19
 * 矩阵局部最小元素。设计一个运行时间和 N 成正比的算法来找出局部最小元素：满足
 * a[i][j] < a[i+1][j]
 * a[i][j] < a[i][j+1]
 * a[i][j] < a[i-1][j]
 * a[i][j] < a[i][j-1]
 * <p>
 * 的索引 i 和 j
 */
public class LocalMinimumInMatrix {

    private static final Pair<Integer, Integer> NOT_FOUND = Pair.of(-1, -1);

    public static void main(String[] args) {
        /**
         *
         */
        int[][] a = new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}};
        System.out.println(localMinimum(a));

        /**
         *   1 2 3 4
         *   2 1 4 5
         *   3 4 5 6
         *   4 5 6 7
         *
         *   输出 1 1
         */
        int[][] a2 = new int[][]{{1, 2, 3, 4}, {2, 1, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}};
        System.out.println(localMinimum(a2));
    }

    /**
     * Find the minimum entry in row n/2, say a[n/2][j].
     * If it's a local minimum, then return it.
     * Otherwise, check it's two vertical neighbors a[n/2-1][j] and a[n/2+1][j].
     * Recur in the half with the smaller neighbor.
     *
     * @param a
     */
    public static Pair<Integer, Integer> localMinimum(int[][] a) {
        int row = a.length - 1; // 行数
        int low = 0;
        int high = row;

        return find(a, low, high);
    }

    private static Pair<Integer, Integer> find(int[][] a, int row_low, int row_high) {
        int row_n = row_low + (row_high - row_low) / 2; // 行
        int col_n = LocalMinimumInArray.localMinimum2(a[row_n], false);

        if (row_n - 1 < 1 || row_n + 1 > a.length - 2 || row_low == row_high) {
            if (col_n <= -1) {
                return NOT_FOUND;
            }

            if (a[row_n][col_n] < a[row_n - 1][col_n] && a[row_n][col_n] < a[row_n + 1][col_n]) {
                return Pair.of(row_n, col_n);
            } else {
                return NOT_FOUND;
            }
        }

        if (col_n > -1) {
            if (a[row_n][col_n] < a[row_n - 1][col_n] && a[row_n][col_n] < a[row_n + 1][col_n]) {
                return Pair.of(row_n, col_n);
            } else if (a[row_n - 1][col_n] <= a[row_n + 1][col_n]) {
                Pair pair = find(a, row_low, row_n);
                if (pair == NOT_FOUND) {
                    return find(a, row_n, row_high);
                } else {
                    return pair;
                }
            } else if (a[row_n - 1][col_n] > a[row_n + 1][col_n]) {
                Pair pair = find(a, row_n, row_high);
                if (pair == NOT_FOUND) {
                    return find(a, row_low, row_n);
                } else {
                    return pair;
                }
            }
        } else {
            Pair pair = find(a, row_low, row_n);
            if (pair == NOT_FOUND) {
                return find(a, row_n, row_high);
            } else {
                return pair;
            }
        }

        return NOT_FOUND;
    }

    static class Pair<A, B> {

        public final A fst;
        public final B snd;

        public Pair(A fst, B snd) {
            this.fst = fst;
            this.snd = snd;
        }

        public String toString() {
            return "Pair[" + fst + "," + snd + "]";
        }

        public static <A, B> Pair<A, B> of(A a, B b) {
            return new Pair<>(a, b);
        }
    }


}
