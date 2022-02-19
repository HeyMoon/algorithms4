package com.dyh.algorithms4.leetcode;

/**
 * @author: dengyunhui
 * @datetime: 2022/2/18 下午4:09
 * @description:
 */
public class DivideTwoInteger {

    public static void main(String[] args) {
        DivideTwoInteger divideTwoInteger = new DivideTwoInteger();
        System.out.println(divideTwoInteger.divide(-2147483648, -1));
    }

    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }

        if (a == 0) {
            return 0;
        }

        boolean isNegative = false;
        if ((a < 0 && b < 0)) {
            a = -a;
            b = -b;
        } else if (a < 0) {
            isNegative = true;
            a = -a;
        } else if (b < 0) {
            isNegative = true;
            b = -b;
        }

        int n = 0;
        while (a >= b) {
            a = a - b;
            n++;
        }

        return isNegative ? -n : n;
    }
}
