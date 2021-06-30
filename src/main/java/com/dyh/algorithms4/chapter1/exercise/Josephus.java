package com.dyh.algorithms4.chapter1.exercise;

import java.util.Arrays;
import java.util.stream.Stream;

public class Josephus {

    static class Person {
        /**
         * 人的初始位置
         */
        int index;

        public Person(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "index=" + index +
                    '}';
        }
    }

    private int m;
    private Object[] items;

    public Josephus(int capacity, int m) {
        this.items = Stream.iterate(new Person(1), n -> new Person(n.index + 1)).limit(capacity).toArray();
        this.m = m;
    }

    boolean stop() {
        return items.length == 1;
    }

    Object kill() {
        if (m >= items.length) {
            throw new UnsupportedOperationException();
        }
        Object o = items[m];
        items[m] = null;
        Object[] temp = new Object[items.length - 1];
        System.arraycopy(items, 0, temp, 0, m);
        System.arraycopy(items, m + 1, temp, m, items.length - m - 1);
        items = temp;
        System.out.println("remaining: " + Arrays.asList(items));
        return o;
    }

    public static void main(String[] args) {
        Josephus josephus = new Josephus(7, 2);
        System.out.println("N: " + 7 + ",m: " + 2);
        while (!josephus.stop()) {
            System.out.println("kill: " + josephus.kill());
        }
    }

}
