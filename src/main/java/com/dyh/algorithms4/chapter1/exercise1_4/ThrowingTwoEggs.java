package com.dyh.algorithms4.chapter1.exercise1_4;

/**
 * user: dengyunhui
 * datetime: 2021/6/27 23:32
 */
public class ThrowingTwoEggs {

    /**
     * 设计一种策略，最多仍 2 * sqrt(N) 即可判断出 F 的值。sqrt 是根号的意思
     * <p>
     * 为了达到 2 * sqrt(N)。我们需要在第 sqrt(N)层，2 * sqrt(N) 层，3 * sqrt(N) ... sqrt(N) * sqrt(N) 层扔鸡蛋，
     * 假设鸡蛋在 k * sqrt(N) 层碎了，那么我们只需要在 (k-1) * sqrt(N) 到 k * sqrt(N) 层之间执行线性查找
     * （复杂度为 sqrt(N),因为有 sqrt(N) 个元素）。所以最后复杂度就是 2 * sqrt(N)
     * <p>
     * <p>
     * 然后想办法把成本降低到 ~c sqrt(F) 次
     *
     * @param a
     * @return
     */
    public static int findF(int[] a) {

        return 0;
    }

}
