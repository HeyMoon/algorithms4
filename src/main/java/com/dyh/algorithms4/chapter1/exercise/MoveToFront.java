package com.dyh.algorithms4.chapter1.exercise;

/**
 * 1.3.40 前移编码
 * 当你读取了一个从未见过的字符时，将它插入表头
 * 当你读取了一个重复的字符时，将它从链表中删去并再次插入表头
 */
public class MoveToFront {

    public static void main(String[] args) {
        MoveToFront moveToFront = new MoveToFront();
        String str = "abc123ads";
        for (int i = 0; i < str.length(); i++) {
            moveToFront.put(str.charAt(i));
        }

        System.out.println(moveToFront);

    }

    @Override
    public String toString() {
        Node node = head;
        StringBuffer stringBuffer = new StringBuffer();
        while (node != null) {
            stringBuffer.append(node.data);
            node = node.next;
        }

        return stringBuffer.toString();
    }

    private Node head;

    public void put(char ch) {
        if (head == null) {
            head = new Node(null, ch, null);
            return;
        } else {
            clearDuplicate(ch);
            Node oldHead = head;
            Node node = new Node(null, ch, null);
            oldHead.prev = node;
            node.next = oldHead;
            head = node;
        }
    }

    private void clearDuplicate(char ch) {
        Node node = head;
        while (node != null) {
            char data = node.data;
            if (ch == data) {
                Node prev = node.prev;
                Node next = node.next;
                if (prev != null) {
                    prev.next = next;
                }

                if (next != null) {
                    next.prev = prev;
                }
                break;
            } else {
                node = node.next;
            }
        }
    }

    static class Node {
        Node prev;
        char data;
        Node next;

        public Node(Node prev, char data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

}
