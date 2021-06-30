package com.dyh.algorithms4.chapter1;

/**
 * 不支持删除元素
 *
 * @param <E>
 */
public interface Bag<E> extends Iterable<E> {


    void add(E e);


    boolean isEmpty();


    int size();


}
