package com.dyh.algorithms4.chapter1.exercise;

import java.util.Arrays;

public class BinarySearch {

    /**
     * 递归
     *
     * @param a
     * @param search
     * @return
     */
    public static int rank(int[] a, int search) {
        int high = a.length - 1;
        int low = 0;

        return search(a, search, high, low);
    }

    private static int search(int[] a, int search, int high, int low) {
        if (high >= low) {
            int middle = low + (high - low) / 2;
            int data = a[middle];
            if (search == data) {
                return middle;
            } else if (search > data) {
                return search(a, search, high, middle + 1);
            } else {
                return search(a, search, middle - 1, low);
            }
        } else {
            return -1;
        }
    }

    /**
     * 不用递归
     *
     * @param a
     * @param search
     * @return
     */
    public static int rank2(int[] a, int search) {
        int high = a.length - 1;
        int low = 0;

        while (high >= low) {
            int middle = low + (high - low) / 2;
            int data = a[middle];
            if (search == data) {
                return middle;
            } else if (search > data) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] a, int low, int high, int search) {
        int local_high = high;
        int local_low = low;
        while (local_high >= local_low) {
            int mid = local_low + (local_high - local_low) / 2;
            if (a[mid] == search) {
                return mid;
            } else if (a[mid] > search) {
                local_high = mid - 1;
            } else {
                local_low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] a = new int[]{1, 2, 3, 4, 5, 6};
        int[] a = new int[]{-1, 2, 3, 1, 4, 5, 6, -3};
        Arrays.sort(a);
        System.out.println(rank2(a, 2));
    }

}
