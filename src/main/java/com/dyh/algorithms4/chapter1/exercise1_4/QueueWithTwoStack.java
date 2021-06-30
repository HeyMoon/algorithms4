package com.dyh.algorithms4.chapter1.exercise1_4;

import com.dyh.algorithms4.chapter1.ResizingArrayStack;
import com.dyh.algorithms4.chapter1.Stack;

import java.util.NoSuchElementException;

/**
 * user: dengyunhui
 * datetime: 2021/6/28 00:06
 */
public class QueueWithTwoStack<E> {

    private Stack stack;
    private Stack stack2;
    private int length;

    public QueueWithTwoStack() {
        stack = new ResizingArrayStack();
        stack2 = new ResizingArrayStack();
    }

    public int length() {
        return length;
    }

    public boolean empty() {
        return length == 0;
    }

    public void enqueue(E e) {
        stack.push(e);
        length++;
    }

    public E dequeue() {
        if (empty()) {
            throw new NoSuchElementException();
        }

        while (stack2.isEmpty()) {
            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
        }

        length--;
        return (E) stack2.pop();
    }


}
