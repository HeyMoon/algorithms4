package com.dyh.algorithms4.chapter1.exercise;

public class LinkedQueue<E> {




    static class Node<E> {
        Node prev;
        E data;
        Node next;

        public Node(Node prev, E data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

}
