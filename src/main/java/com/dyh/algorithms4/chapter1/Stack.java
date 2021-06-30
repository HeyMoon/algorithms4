package com.dyh.algorithms4.chapter1;

/**
 * 后进先出
 *
 * @param <E>
 */
public interface Stack<E> extends Iterable<E> {

    void push(E e);


    E pop();


    boolean isEmpty();


    int size();


}
