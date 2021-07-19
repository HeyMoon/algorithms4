package com.dyh.algorithms4.chapter4.directedDraph;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/19 23:49
 * @description: 强连通分量
 * <p>
 * Kosaraju 算法：
 * 1. 在给定的一副有向图 G 中，使用 DepthFirstOrder 来计算它的反向图 G-R 的逆后序排列
 * 2. 在 G 中进行标准的深度优先搜索，但是要按照刚才计算得到的顺序而非标准的顺序来访问所有未被标记的顶点
 * 3. 在构造函数中，所有在同一个递归 dfs() 调用中被访问到的顶点都在同一个强连通分量中，将它们按照和 CC 相同的方式识别出来
 */
public class KosarajuSCC {

    private boolean[] marked; // 已访问过的顶点
    private int[] id;         // 强连通分量标识符
    private int count;        // 强连通分量的数量

    public KosarajuSCC(Digraph g) {
        marked = new boolean[g.v()];
        id = new int[g.v()];
        DepthFirstOrder order = new DepthFirstOrder(g.reverse());
        for (int s : order.reversePost()) {
            if (!marked[s]) {
                dfs(g, s);
                count++;
            }
        }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }

    }

    /**
     * v 和 w 是强连通分量吗
     *
     * @param v
     * @param w
     * @return
     */
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }


}
