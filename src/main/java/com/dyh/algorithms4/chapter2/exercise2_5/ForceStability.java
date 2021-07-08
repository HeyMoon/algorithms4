package com.dyh.algorithms4.chapter2.exercise2_5;

import com.dyh.algorithms4.StdIn;
import com.dyh.algorithms4.chapter2.Selection;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/8 22:41
 * @description: 2.5.18
 * 编写一段能够将任意排序方法变得稳定的封装代码。
 * 创建一种新的数据类型作为键，将键的初始索引保存在其中，并在调用 sort() 之后再根据保存的
 * 索引恢复键的原始顺序
 * <p>
 * 何为排序算法稳定性：
 * 假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些记录的相对次序保持不变，
 * 即在原序列中，r[i]=r[j]，且r[i]在r[j]之前，而在排序后的序列中，r[i]仍在r[j]之前，则称这种排序算法是稳定的；
 * 否则称为不稳定的。
 */
public class ForceStability {

    static class Key implements Comparable<Key> {
        /**
         * 排序前的位置
         */
        private int index;

        private Comparable data;

        public Key(int index, Comparable data) {
            this.index = index;
            this.data = data;
        }

        @Override
        public int compareTo(Key key) {
            if (this.data.compareTo(key.data) > 0) {
                return 1;
            } else if (this.data.compareTo(key.data) < 0) {
                return -1;
            }

            return 0;
        }

        @Override
        public String toString() {
            return "Key{" +
                    "index=" + index +
                    ", data=" + data +
                    '}';
        }
    }

    private static Comparator<Key> indexComparator = new Comparator<Key>() {
        @Override
        public int compare(Key key1, Key key2) {
            if (key1.index > key2.index) {
                return 1;
            } else if (key1.index < key2.index) {
                return -1;
            }
            return 0;
        }
    };

    /**
     * forceStability
     *
     * @param a
     */
    private static void forceStability(Key[] a, Comparator indexComparator) {
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) == 0) {
                count++;
            } else {
                if (count > 1) {
                    Arrays.sort(a, i - count, i, indexComparator);
                    count = 1;
                }
            }
        }

        if (count > 1) {
            Arrays.sort(a, a.length - count, a.length, indexComparator);
        }
    }

    public static void main(String[] args) {
        System.out.println("enter number of keys:");
        int n = StdIn.readInt();
        System.out.println(n);

        Key[] keys = new Key[n];
        for (int i = 0; i < n; i++) {
            String s = StdIn.readString();
            Key key = new Key(i, s);
            keys[i] = key;
        }

        Selection.sort(keys);

        for (int i = 0; i < keys.length; i++) {
            System.out.println(keys[i]);
        }

        forceStability(keys, indexComparator);

        System.out.println("after force stability");

        for (int i = 0; i < keys.length; i++) {
            System.out.println(keys[i]);
        }
    }

}
