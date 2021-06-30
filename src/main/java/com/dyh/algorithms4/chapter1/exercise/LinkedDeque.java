package com.dyh.algorithms4.chapter1.exercise;

/**
 * 双向队列，支持在两端添加或删除元素
 * <p>
 * 先进先出
 */
public class LinkedDeque<E> {

    public static void main(String[] args) {
        LinkedDeque linkedDeque = new LinkedDeque();
        linkedDeque.pushFirst("111");
        linkedDeque.pushLast("222");
        System.out.println(linkedDeque.popFirst());
        System.out.println(linkedDeque.popFirst());
    }

    class Node<E> {
        Node prev;
        E e;
        Node next;

        public Node(Node prev, E e, Node next) {
            this.prev = prev;
            this.e = e;
            this.next = next;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    boolean isEmpty() {
        return size <= 0;
    }

    int size() {
        return size;
    }

    /**
     * 把元素添加到队头
     *
     * @param e
     */
    void pushFirst(E e) {
        Node oldHead = head;
        Node node = new Node(null, e, oldHead);
        head = node;
        if (tail == null) {
            tail = node;
        } else {
            oldHead.prev = node;
        }
        size++;
    }

    /**
     * 把元素添加到队尾
     *
     * @param e
     */
    void pushLast(E e) {
        Node oldTail = tail;
        Node node = new Node(oldTail, e, null);
        tail = node;
        if (head == null) {
            head = node;
        } else {
            oldTail.next = node;
        }
        size++;
    }

    E popFirst() {
        if (head == null) {
            return null;
        }

        E e = (E) head.e;
        head = head.next;

        return e;
    }

    E popLast() {
        if (tail == null) {
            return null;
        }

        E e = (E) tail.e;
        tail = tail.prev;
        return e;
    }
}
