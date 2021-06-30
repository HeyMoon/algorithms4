package com.dyh.algorithms4.chapter1.exercise1_4;

import com.dyh.algorithms4.chapter1.ResizingArrayStack;
import com.dyh.algorithms4.chapter1.Stack;

import java.util.NoSuchElementException;

/**
 * user: dengyunhui
 * datetime: 2021/6/28 00:26
 * <p>
 * push，pop 操作的是同一端，enqueue 和 push 对应，但是操作的是另一端
 */
public class StequeWithTwoStack<E> {

    private Stack stack;
    private Stack stack2;
    private int length;

    public StequeWithTwoStack() {
        stack = new ResizingArrayStack();
        stack2 = new ResizingArrayStack();
    }

    public boolean empty() {
        return length == 0;
    }

    public void push(E e) {
        stack.push(e);
        length++;
    }


    public E pop() {
        if (empty()) {
            throw new NoSuchElementException();
        }

        length--;
        if (stack.isEmpty()) {
            return (E) stack2.pop();
        } else {
            return (E) stack.pop();
        }
    }

    /**
     * @param e
     */
    public void enqueue(E e) {
        length++;
        stack2.push(e);
    }

    public static void main(String[] args) {
        StequeWithTwoStack<String> stringSteque = new StequeWithTwoStack<>();
        stringSteque.push("111");
        stringSteque.push("222");
        System.out.println(stringSteque.pop());
        stringSteque.push("333");
        stringSteque.enqueue("121");
        while (!stringSteque.empty()) {
            System.out.println(stringSteque.pop());
        }

    }

}
