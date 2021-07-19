package com.dyh.algorithms4.chapter4.directedDraph;

import com.dyh.algorithms4.chapter1.ResizingArrayStack;
import com.dyh.algorithms4.chapter1.Stack;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/19 23:21
 * @description: 有向环检测
 */
public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack; // 递归调用的栈上的所有顶点
    private Stack<Integer> cycle;


    /**
     * 一旦找到一条边 v -> w, 且 w 已经存在于栈中，就找到了一个环
     *
     * @param g
     */
    public DirectedCycle(Digraph g) {
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        onStack = new boolean[g.v()];
        for (int i = 0; i < g.v(); i++) {
            if (!marked[i]) {
                dfs(g, i);
            }
        }
    }

    private void dfs(Digraph g, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (hasCycle()) {
                return;
            }

            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            } else if (onStack[w]) {
                cycle = new ResizingArrayStack<>();
                for (int i = 0; i != w; i = edgeTo[i]) {
                    cycle.push(i);
                }

                cycle.push(w);
                cycle.push(v);
            }
        }

        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

}
