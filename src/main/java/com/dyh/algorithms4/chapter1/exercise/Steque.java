package com.dyh.algorithms4.chapter1.exercise;

/**
 * push,pop 都是对队列同一端的操作， enqueue 和 push 对应，但操作的是队列的另一端
 */
public class Steque<E> {

    private Node head;

    private int size;

    void push(E e) {
        Node oldHead = head;
        Node node = new Node(e, oldHead);
        head = node;
        size++;
    }

    E pop() {
        if (head == null) {
            return null;
        }
        E e = (E) head.e;
        head = head.next;
        size--;
        return e;
    }


    void enqueue(E e) {
        Node node = new Node(e, null);
        if (isEmpty()) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    boolean isEmpty() {
        return head == null;
    }

    class Node<E> {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Steque<String> stringSteque = new Steque<>();
        stringSteque.push("111");
        stringSteque.push("222");
        System.out.println(stringSteque.pop());
        stringSteque.push("333");
        stringSteque.enqueue("121");
        while (!stringSteque.isEmpty()) {
            System.out.println(stringSteque.pop());
        }


    }

}
