package com.dyh.algorithms4.chapter4;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/19 22:21
 * @description: 4.1.35
 */
public class Bridge {
    private int bridges;      // number of bridges
    private int cnt;          // counter
    private int[] pre;        // pre[v] = order in which dfs examines v
    private int[] low;        // low[v] = lowest preorder of any vertex connected to v

    public Bridge(Graph G) {
        low = new int[G.vertex()];
        pre = new int[G.vertex()];
        for (int v = 0; v < G.vertex(); v++)
            low[v] = -1;
        for (int v = 0; v < G.vertex(); v++)
            pre[v] = -1;

        for (int v = 0; v < G.vertex(); v++)
            if (pre[v] == -1)
                dfs(G, v, v);
    }

    public int components() {
        return bridges + 1;
    }

    private void dfs(Graph G, int u, int v) {
        pre[v] = cnt++;
        low[v] = pre[v];
        for (int w : G.adj(v)) {
            if (pre[w] == -1) {
                dfs(G, v, w);
                low[v] = Math.min(low[v], low[w]);
                if (low[w] == pre[w]) {
                    StdOut.println(v + "-" + w + " is a bridge");
                    bridges++;
                }
            }

            // update low number - ignore reverse of edge leading to v
            else if (w != u)
                low[v] = Math.min(low[v], pre[w]);
        }
    }

    // test client
    public static void main(String[] args) {

    }


}
