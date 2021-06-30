package com.dyh.algorithms4.chapter1.exercise;

import java.util.Random;

public class RandomQueue<E> {

    private int size;
    private Object[] items;

    public RandomQueue(int capacity) {
        this.items = new Object[capacity];
    }

    public static void main(String[] args) {
        RandomQueue randomQueue = new RandomQueue(3);
        randomQueue.enqueue("111");
        randomQueue.enqueue("222");
        randomQueue.enqueue("333");
        randomQueue.enqueue("444");

        while (!randomQueue.isEmpty()) {
            System.out.println(randomQueue.dequeue());
        }
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(E e) {
        if (size == items.length) {
            resize(2 * items.length);
        }

        items[size++] = e;
    }

    private void resize(int i) {
        Object[] temp = new Object[i];
        System.arraycopy(items, 0, temp, 0, items.length);
        items = temp;
    }

    E dequeue() {
        int index = new Random().nextInt(size);
        E e = (E) items[size - 1];
        items[index] = e;
        items[size - 1] = null;
        size--;
        return e;
    }

}
