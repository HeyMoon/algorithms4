package com.dyh.algorithms4.chapter4;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/15 22:40
 * @description:
 */
public class DepthFirstSearch extends Search {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int s) {
        super(g, s);
        marked = new boolean[g.vertex()];
        dfs(g, s);
    }

    /**
     * 深度优先搜索
     * 在访问其中一个顶点时：
     * 1. 将它标记为已访问
     * 2. 递归地访问他的所有没有被标记过的邻居顶点
     *
     * @param g
     * @param s
     */
    private void dfs(Graph g, int s) {
        marked[s] = true;
        count++;
        for (int w : g.adj(s)) {
            // 如果 w 没有被标记过，进行递归调用
            // 如果 w 被标记过，那么跳过这条边
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }
}
