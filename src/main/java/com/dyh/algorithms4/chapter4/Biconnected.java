package com.dyh.algorithms4.chapter4;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/19 22:26
 * @description: 双向连通性
 */
public class Biconnected {
    private int[] low;
    private int[] pre;
    private int cnt;
    private boolean[] articulation;

    public Biconnected(Graph G) {
        low = new int[G.vertex()];
        pre = new int[G.vertex()];
        articulation = new boolean[G.vertex()];
        for (int v = 0; v < G.vertex(); v++)
            low[v] = -1;
        for (int v = 0; v < G.vertex(); v++)
            pre[v] = -1;

        for (int v = 0; v < G.vertex(); v++)
            if (pre[v] == -1)
                dfs(G, v, v);
    }

    private void dfs(Graph G, int u, int v) {
        int children = 0;
        pre[v] = cnt++;
        low[v] = pre[v];
        for (int w : G.adj(v)) {
            if (pre[w] == -1) {
                children++;
                dfs(G, v, w);

                // update low number
                low[v] = Math.min(low[v], low[w]);

                // non-root of DFS is an articulation point if low[w] >= pre[v]
                if (low[w] >= pre[v] && u != v)
                    articulation[v] = true;
            }

            // update low number - ignore reverse of edge leading to v
            else if (w != u)
                low[v] = Math.min(low[v], pre[w]);
        }

        // root of DFS is an articulation point if it has more than 1 child
        if (u == v && children > 1)
            articulation[v] = true;
    }

    // is vertex v an articulation point?
    public boolean isArticulation(int v) {
        return articulation[v];
    }

    // test client
    public static void main(String[] args) {

    }

}
