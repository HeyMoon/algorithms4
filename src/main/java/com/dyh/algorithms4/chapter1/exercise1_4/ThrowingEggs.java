package com.dyh.algorithms4.chapter1.exercise1_4;

/**
 * user: dengyunhui
 * datetime: 2021/6/27 23:10
 * <p>
 * 1.4.24 扔鸡蛋
 * <p>
 * 假设你面前有一栋 N 层的大楼和许多鸡蛋，假设将鸡蛋从 F 层或者更高的地方扔下，鸡蛋才会摔碎
 * 否则则不会。
 * 首先设计一种策略来确定 F 的值，其中仍 ~lgN 次鸡蛋后摔碎的鸡蛋数量是 ~lgN。
 * 然后想办法将成本降低到 ~2lgF,当 N 远比 F 大时
 * <p>
 * binary search; repeated doubling and binary search
 */
public class ThrowingEggs {

    /**
     * 设计一种策略来确定 F 的值，其中仍 ~lgN 次鸡蛋后摔碎的鸡蛋数量是 ~lgN。
     * 也就是说经过 lgN 次之后才找到 F 。
     * <p>
     * 用 binary search
     *
     * @param a
     * @return
     */
    public static int findF(int[] a) {

        return 0;
    }

    /**
     * 将成本降低到 2lgF,当 N 远比 F 大时。
     * 当 N 远比 F 大时，我们可以从第一层开始仍鸡蛋，
     * 如果鸡蛋没碎，再翻倍(double)，从第二层仍
     * 如果鸡蛋还没碎，在翻倍(double),从第四层仍
     * <p>
     * repeated doubling and binary search
     *
     * @param a
     * @return
     */
    public static int lowCost(int[] a) {


        return 0;
    }

}
