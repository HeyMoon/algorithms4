package com.dyh.algorithms4.chapter4.directedDraph;

import com.dyh.algorithms4.chapter1.Queue;
import com.dyh.algorithms4.chapter1.ResizingArrayStack;
import com.dyh.algorithms4.chapter1.Stack;
import com.dyh.algorithms4.chapter1.exercise.QueueWithTwoStack;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/19 22:48
 * @description:
 */
public class BreadthFirstDirectedPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    /**
     * 在 G 中找出所有起点为 s 的路径
     *
     * @param g
     * @param s
     */
    public BreadthFirstDirectedPaths(Digraph g, int s) {
        this.s = s;
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        bfs(g, s);
    }

    private void bfs(Digraph g, int v) {
        Queue<Integer> queue = new QueueWithTwoStack();
        marked[v] = true;
        queue.enqueue(v);

        while (!queue.isEmpty()) {
            int t = queue.dequeue();
            for (int w : g.adj(t)) {
                if (!marked[w]) {
                    edgeTo[w] = t;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }

    }


    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new ResizingArrayStack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }

        path.push(v);
        return path;
    }


}
