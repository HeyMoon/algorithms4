package com.dyh.algorithms4.dynamicprogramming;

/**
 * @author: dengyunhui
 * @datetime: 2022/2/7 下午9:43
 * @description:
 */
public class Fibonacci {

    private final int NIL = -1;

    private int[] lookup;

    public Fibonacci(int n) {
        //初始化查找表
        lookup = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            lookup[i] = NIL;
        }
    }

    public int fib(int n) {
        if (lookup[n] == NIL) {
            if (n <= 1) {
                lookup[n] = n;
            } else {
                lookup[n] = fib(n - 1) + fib(n - 2);
            }
        }

        return lookup[n];
    }

    public int fib2(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        int n = 40;
        Fibonacci f = new Fibonacci(n);
        System.out.println(f.fib(n));
        System.out.println(f.fib2(n));
    }

}
