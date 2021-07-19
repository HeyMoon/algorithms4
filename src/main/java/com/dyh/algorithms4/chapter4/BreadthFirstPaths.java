package com.dyh.algorithms4.chapter4;

import com.dyh.algorithms4.chapter1.Queue;
import com.dyh.algorithms4.chapter1.ResizingArrayStack;
import com.dyh.algorithms4.chapter1.Stack;
import com.dyh.algorithms4.chapter1.exercise.QueueWithTwoStack;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/17 19:17
 * @description: 解决最短路径问题
 */
public class BreadthFirstPaths extends Paths {

    private static final int INFINITY = Integer.MAX_VALUE;

    private boolean[] marked; // 到达该顶点的最短路径已知吗
    private int[] edgeTo; //
    private final int s; // 起点
    private int[] distTo; // distTo[v] = number of edges shortest s-v path

    /**
     * 在 G 中找出所有起点为 s 的路径
     *
     * @param g
     * @param s
     */
    public BreadthFirstPaths(Graph g, int s) {
        super(g, s);
        marked = new boolean[g.vertex()];
        edgeTo = new int[g.vertex()];
        distTo = new int[g.vertex()];
        for (int i = 0; i < g.vertex(); i++) {
            distTo[i] = INFINITY;
        }

        this.s = s;
        bfs(g, s);
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new QueueWithTwoStack<>();
        marked[s] = true;
        distTo[s] = 0;
        queue.enqueue(s);

        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }

    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public int distTo(int v) {
        return distTo[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new ResizingArrayStack<>();
        for (int x = v; distTo[x] != 0; x = edgeTo[x]) {
            path.push(x);
        }

        path.push(v);
        return path;
    }
}
