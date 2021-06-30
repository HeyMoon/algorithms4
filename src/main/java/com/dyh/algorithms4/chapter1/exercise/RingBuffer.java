package com.dyh.algorithms4.chapter1.exercise;

/**
 * 先进先出
 */
public class RingBuffer<E> {

    private int capacity;

    private Object[] items;


    public RingBuffer(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];

    }

    public void push(E e) throws InterruptedException {
        if (isFull()) {

        }
    }

    public E get() {
        if (isEmpty()) {

        }
        return null;
    }


    private boolean isFull() {
        return items.length >= capacity;
    }

    private boolean isEmpty() {
        return items.length == 0;
    }


}
