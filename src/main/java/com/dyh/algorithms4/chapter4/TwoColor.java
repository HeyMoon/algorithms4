package com.dyh.algorithms4.chapter4;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/18 11:10
 * @description: g 是二分图吗
 */
public class TwoColor {

    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph g) {
        marked = new boolean[g.vertex()];
        color = new boolean[g.vertex()];
        for (int s = 0; s < g.vertex(); s++) {
            if (!marked[s]) {
                dfs(g, s);
            }
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(g, w);
            } else if (color[w] == color[v]) {
                isTwoColorable = true;
            }
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }

}
