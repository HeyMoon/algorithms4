package com.dyh.algorithms4.chapter4;

import com.dyh.algorithms4.chapter1.ResizingArrayStack;
import com.dyh.algorithms4.chapter1.Stack;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/16 20:45
 * @description: 1. 连通性。给定的两个顶点是否连通
 *               2. 单点路径。给定一幅图和一个起点 s,是否存在一条路径
 */
public class DepthFirstPaths extends Paths {

    private boolean[] marked;

    private int[] edgeTo;

    private final int s; // 起点

    /**
     * 在 G 中找出所有起点为 s 的路径
     *
     * @param g
     * @param s
     */
    public DepthFirstPaths(Graph g, int s) {
        super(g, s);
        marked = new boolean[g.vertex()];
        edgeTo = new int[g.vertex()];
        this.s = s;

        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
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
