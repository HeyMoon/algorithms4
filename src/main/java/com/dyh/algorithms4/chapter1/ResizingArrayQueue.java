package com.dyh.algorithms4.chapter1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author: dengyunhui
 * @datetime: 2021/12/3 下午3:04
 * @description:
 */
public class ResizingArrayQueue<Item> implements Queue<Item> {

    private Object[] data;
    private int head;
    private int tail;
    private int n;

    public ResizingArrayQueue() {
        data = new Object[4];
        head = tail = n = 0;
    }

    @Override
    public void enqueue(Item item) {
        if (isFull()) {
            resize(2 * n);
        }

        data[tail++] = item;
        if (tail >= data.length) {
            tail = 0;
        }

        n++;
    }

    /**
     * 这里是关键
     *
     * @param newLength
     */
    private void resize(int newLength) {
        Object[] t = new Object[newLength];
        for (int i = 0; i < n; i++) {
            t[i] = data[(head + i) % data.length];
        }

        head = 0;
        tail = n;
        data = t;
    }

    @Override
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Item item = (Item) data[head];
        data[head++] = null;
        n--;

        if (head >= data.length) {
            head = 0;
        }

        if (n > 0 && n <= data.length / 4) {
            resize(data.length / 2);
        }

        return item;
    }

    private boolean isFull() {
        return data.length == n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }


    public static void main(String[] args) {
        Queue queue = new ResizingArrayQueue();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
