package com.dyh.algorithms4.chapter4.directedDraph;

import com.dyh.algorithms4.chapter1.Queue;
import com.dyh.algorithms4.chapter1.ResizingArrayStack;
import com.dyh.algorithms4.chapter1.Stack;
import com.dyh.algorithms4.chapter1.exercise.QueueWithTwoStack;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/19 23:37
 * @description:
 */
public class DepthFirstOrder {

    private boolean[] marked;
    private Queue<Integer> pre;   // 前序排列
    private Queue<Integer> post;  // 后序排列
    private Stack<Integer> reversePost; // 逆后序排列

    public DepthFirstOrder(Digraph g) {
        pre = new QueueWithTwoStack<>();
        post = new QueueWithTwoStack<>();
        reversePost = new ResizingArrayStack<>();

        marked = new boolean[g.v()];
        for (int i = 0; i < g.v(); i++) {
            dfs(g, i);
        }
    }

    private void dfs(Digraph g, int v) {
        pre.enqueue(v);

        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }


}
