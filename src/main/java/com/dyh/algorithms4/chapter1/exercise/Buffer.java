package com.dyh.algorithms4.chapter1.exercise;

import com.dyh.algorithms4.chapter1.ResizingArrayStack;

public class Buffer {

    private ResizingArrayStack left;

    private ResizingArrayStack right;

    private int size;

    public Buffer() {
        left = new ResizingArrayStack();
        right = new ResizingArrayStack();
    }


    public void insert(char c) {
        left.push(c);
        size++;
    }

    public char delete() {
        char ch = (char) left.pop();
        size--;
        return ch;
    }

    public void left(int k) {
        for (int i = 0; i < k; i++) {
            right.push(left.pop());
        }
    }

    public void right(int k) {
        for (int i = 0; i < k; i++) {
            left.push(right.pop());
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        while (!left.isEmpty()) {
            stringBuffer.append(left.pop());
        }

        while (!right.isEmpty()) {
            stringBuffer.append(right.pop());
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        buffer.insert('1');
        buffer.insert('2');
        buffer.insert('3');
        buffer.insert('4');
        buffer.delete();

        buffer.left(2);
        System.out.println(buffer);

    }

}
