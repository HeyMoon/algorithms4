package com.dyh.algorithms4.chapter2.exercise2_2;

import java.util.LinkedList;

/**
 * @author: dengyunhui
 * @datetime: 2021/6/30 22:50
 * @description:
 */
public class E_2_2_15 {

    public static final String[] STRINGS = new String[]{"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};

    public static void sort(int n) {
        LinkedList<LinkedList<Comparable>> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            LinkedList<Comparable> list = new LinkedList<>();
            list.push(STRINGS[i]);
            linkedList.add(list);
        }

        while (linkedList.size() > 1) {
            LinkedList result = E_2_2_14.sort(linkedList.poll(), linkedList.poll());
            System.out.println("merge result:" + result);
            linkedList.add(result);
        }

        System.out.println(linkedList);
    }

    public static void main(String[] args) {
        sort(10);
    }

}
