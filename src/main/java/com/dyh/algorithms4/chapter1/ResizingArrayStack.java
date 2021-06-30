package com.dyh.algorithms4.chapter1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ResizingArrayStack<E> implements Stack<E> {

    private Object[] items;

    private int length;


    public ResizingArrayStack(int capacity) {
        items = new Object[capacity];
    }

    public ResizingArrayStack() {
        items = new Object[16];
    }

    private boolean isFull() {
        return length == items.length;
    }

    @Override
    public void push(E e) {
        if (isFull()) {
            resize(2 * items.length);
        }

        items[length++] = e;
    }

    private void resize(int newLength) {
        Object[] temp = new Object[newLength];
        System.arraycopy(items, 0, temp, 0, items.length - 1);
        items = temp;
    }

    @Override
    public E pop() {
        E e = (E) items[--length];
        items[length] = null;

        if (length > 0 && length == items.length / 4) {
            resize(items.length / 2);
        }

        return e;
    }

    @Override
    public String toString() {
        return "ResizingArrayStack{" +
                "items=" + Arrays.toString(items) +
                ", length=" + length +
                '}';
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int size() {
        return length;
    }

    private class ReverseArrayIterator implements Iterator<E> {

        private int i = length;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public E next() {
            int index = i - 1;
            E e = (E) items[index];
            i = index;
            return e;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
}
