package com.dyh.algorithms4.dynamicprogramming;

/**
 * @author: dengyunhui
 * @datetime: 2021/8/23 22:42
 * @description: 楼梯路线
 * 一個方格棋盤 x * y，從左上角走到右下角，每次只能往右走一格或者往下走一格。請問有幾種走法？
 */
public class StaircaseWalk {

    private int x;
    private int y;
    private int[][] c;

    public static void main(String[] args) {
        StaircaseWalk staircaseWalk = new StaircaseWalk(8, 8);
        System.out.println(staircaseWalk.f(7));

    }

    public int f(int n) {
        if (n <= x && n <= y) {
            staircaseWalk();
            return c[n][n];
        }
        return 0;
    }

    public StaircaseWalk(int x, int y) {
        this.x = x;
        this.y = y;
        c = new int[x][y];
    }

    public void staircaseWalk() {
        // initial state
        for (int i = 0; i < x; i++) {
            c[i][0] = 1;
        }

        for (int i = 0; i < y; i++) {
            c[0][i] = 1;
        }

        // computation
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                c[i][j] = c[i][j - 1] + c[i - 1][j];
            }
        }
    }

}
