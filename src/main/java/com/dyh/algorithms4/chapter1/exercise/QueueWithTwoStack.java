package com.dyh.algorithms4.chapter1.exercise;

import com.dyh.algorithms4.chapter1.ResizingArrayStack;

import java.util.NoSuchElementException;

public class QueueWithTwoStack<E> {

    private ResizingArrayStack stack1;
    private ResizingArrayStack stack2;
    private int size;

    public QueueWithTwoStack() {
        stack1 = new ResizingArrayStack();
        stack2 = new ResizingArrayStack();
    }


    /**
     * 入队
     *
     * @param e
     */
    public void enqueue(E e) {
        stack1.push(e);
        size++;
    }

    private boolean empty() {
        return size == 0;
    }

    /**
     * 出队
     *
     * @return
     */
    public E dequeue() {
        if (empty()) {
            throw new NoSuchElementException();
        }

        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        size--;
        E e = (E) stack2.pop();
        return e;
    }

    public static void main(String[] args) {
        QueueWithTwoStack queue = new QueueWithTwoStack();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        while (!queue.empty()){
            System.out.println(queue.dequeue());
        }
    }


}
