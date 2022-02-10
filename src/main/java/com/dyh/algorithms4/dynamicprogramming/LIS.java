package com.dyh.algorithms4.dynamicprogramming;

/**
 * @author: dengyunhui
 * @datetime: 2022/2/8 下午3:23
 * @description: Longest Increasing Subsequence
 */
public class LIS {


    private static int lis;

    private static int doRecursiveLis(int[] arr, int n) {
        if (n == 1) {
            return 1;
        }

        int res, max = 1;
        // 递归获取 arr[0], arr[1] ... arr[n-2] 的 LIS
        for (int i = 1; i < n; i++) {
            res = doRecursiveLis(arr, i);
            //如果数组后面的数大于前面的数
            if (arr[i - 1] < arr[n - 1] && res + 1 > max) {
                max = res + 1;
            }
        }

        if (lis < max)
            lis = max;

        return max;
    }

    public static int recursiveLis(int[] arr, int n) {
        lis = 1;

        doRecursiveLis(arr, n);

        return lis;
    }


    public static int lis(int[] arr, int n) {
        int lis[] = new int[n];
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        int n = arr.length;
        System.out.println("Length of lis is " + lis(arr, n));
        System.out.println("Length of lis is " + recursiveLis(arr, n));
    }

}
