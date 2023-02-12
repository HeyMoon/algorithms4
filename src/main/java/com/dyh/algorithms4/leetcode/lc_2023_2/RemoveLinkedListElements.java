package com.dyh.algorithms4.leetcode.lc_2023_2;

/**
 * @author: dengyunhui
 * @datetime: 2023/1/30 上午10:45
 * @description:
 */
public class RemoveLinkedListElements {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode prev = newHead;

        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }

        return newHead.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0, head);

        ListNode fastNode = newHead;
        ListNode slowNode = newHead;

        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }

        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        slowNode.next = slowNode.next.next;

        return newHead.next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;

        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }

        return h1;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            ListNode index1 = head;

            while (index1 != fast) {
                index1 = index1.next;
                fast = fast.next;
            }
            return fast;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);

        /*listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;*/

        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        ListNode listNode = removeLinkedListElements.removeNthFromEnd(listNode1, 1);
        System.out.println(listNode);
    }
}
