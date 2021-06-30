package com.dyh.algorithms4.chapter1;

/**
 * 先进先出
 *
 * @param <E>
 */
public interface Queue<E> extends Iterable<E> {

    /**
     * 添加一个元素
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 删除最近添加的元素
     *
     * @return
     */
    E dequeue();

    boolean isEmpty();

    int size();


}
