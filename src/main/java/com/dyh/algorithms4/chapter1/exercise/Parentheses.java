package com.dyh.algorithms4.chapter1.exercise;

import com.dyh.algorithms4.chapter1.ResizingArrayStack;
import com.dyh.algorithms4.chapter1.Stack;

/**
 * @author: dengyunhui
 * @datetime: 2021/12/6 下午9:01
 * @description:
 */
public class Parentheses {

    private Stack stack;

    public Parentheses() {
        stack = new ResizingArrayStack();
    }


    public boolean read(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char peer = (char) stack.pop();
                if (ch == ')' && peer == '('
                        || ch == ']' && peer == '['
                        || ch == '}' && peer == '{') {
                    continue;
                } else {
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }

}
