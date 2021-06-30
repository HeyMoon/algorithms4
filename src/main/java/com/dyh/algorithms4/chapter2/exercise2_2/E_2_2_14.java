package com.dyh.algorithms4.chapter2.exercise2_2;

import com.dyh.algorithms4.chapter2.Example;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author: dengyunhui
 * @datetime: 2021/6/30 22:39
 * @description: 归并有序的队列
 */
public class E_2_2_14 {

    /**
     * @param list1
     * @param list2
     * @return
     */
    public static LinkedList sort(LinkedList<Comparable> list1, LinkedList<Comparable> list2) {
        LinkedList list = new LinkedList();

        while (!list1.isEmpty()) {
            if (list2.isEmpty()) {
                list.addLast(list1.poll());
                continue;
            }

            if (Example.less(list1.peek(), list2.peek())) {
                list.addLast(list1.poll());
            } else {
                list.addLast(list2.poll());
            }
        }

        while (!list2.isEmpty()) {
            list.addLast(list2.poll());
        }

        return list;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"E", "A", "S", "Y", "Q", "U"};
        String[] strings1 = new String[]{"S", "T", "I", "O", "N"};
        MergeX.sort(strings);
        MergeX.sort(strings1);
        LinkedList list1 = new LinkedList();
        Collections.addAll(list1, strings);

        LinkedList list2 = new LinkedList();
        Collections.addAll(list2, strings1);

        LinkedList result = sort(list1, list2);
        while (!result.isEmpty()) {
            System.out.print(result.pollFirst() + " ");
        }
    }


}
