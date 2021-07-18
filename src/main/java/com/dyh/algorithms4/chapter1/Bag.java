package com.dyh.algorithms4.chapter1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 不支持删除元素
 *
 * @param <E>
 */
public class Bag<E> implements Iterable<E> {

    private Node<E> first;    // beginning of bag
    private int n;

    private static class Node<E> {
        private E e;
        private Node<E> next;
    }

    public Bag() {
        first = null;
        n = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator(first);
    }


    public void add(E e) {
        Node<E> oldfirst = first;
        first = new Node<E>();
        first.e = e;
        first.next = oldfirst;
        n++;
    }


    public boolean isEmpty() {
        return first == null;
    }


    public int size() {
        return n;
    }


    private class LinkedIterator implements Iterator<E> {
        private Node<E> current;

        public LinkedIterator(Node<E> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E item = current.e;
            current = current.next;
            return item;
        }
    }
}
