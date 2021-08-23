package com.dyh.algorithms4.dynamicprogramming;

/**
 * @author: dengyunhui
 * @datetime: 2021/8/23 21:46
 * @description: 爬楼梯
 */
public class StairsClimbing {

    private int[] table = new int[6];


    public static void main(String[] args) {
        StairsClimbing stairsClimbing = new StairsClimbing();
        stairsClimbing.stairsClimbing();
    }

    public void stairsClimbing() {
        for (int i = 0; i <= 5; i++)
            table[i] = 0;

        int n = 5;
        System.out.println("爬到 " + n + " 阶" + "， 共有 " + f(5) + " 中方法");
    }

    private int f(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (table[n] != 0) {
            return table[n];
        }

        return table[n] = f(n - 1) + f(n - 2);
    }

}
