package com.dyh.algorithms4.chapter4;

import com.dyh.algorithms4.chapter1.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CC {

    private boolean[] marked;
    private int[] id; //顶点索引数组。如果 v 属于第 i 个连通分量，则 id[v] 的值为 i
    private int count;

    public CC(Graph g) {
        marked = new boolean[g.vertex()];
        id = new int[g.vertex()];
        for (int i = 0; i < g.vertex(); i++) {
            if (!marked[i]) {
                dfs(g, i);
                count++;
            }
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    /**
     * v 和 w 连通吗
     *
     * @param v
     * @param w
     * @return
     */
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * 连通分量数
     *
     * @return
     */
    public int count() {
        return count;
    }

    /**
     * v 所在的连通分量的标识符
     *
     * @param v
     * @return
     */
    public int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));
        CC cc = new CC(g);
        int m = cc.count();
        StdOut.println(m + " components");
        Bag<Integer>[] components = new Bag[m];
        for (int i = 0; i < m; i++) {
            components[i] = new Bag<>();
        }

        for (int i = 0; i < g.vertex(); i++) {
            components[cc.id(i)].add(i);
        }

        for (int i = 0; i < m; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }

}
