package com.dyh.algorithms4.chapter4.directedDraph;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/19 22:42
 * @description:
 */
public class DirectedDFS {

    private boolean[] marked;

    public DirectedDFS(Digraph g, int s) {
        marked = new boolean[g.v()];
        dfs(g, s);
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public DirectedDFS(Digraph g, Iterable<Integer> sources) {
        marked = new boolean[g.v()];
        for (int s : sources) {
            if (!marked[s]) {
                dfs(g, s);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

}
