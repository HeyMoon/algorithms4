package com.dyh.algorithms4.chapter4;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/18 10:58
 * @description: 检测是否存在环
 */
public class Cycle {

    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph g) {
        marked = new boolean[g.vertex()];
        for (int i = 0; i < g.vertex(); i++) {
            if (!marked[i]) {
                dfs(g, i, i);
            }
        }

    }

    private void dfs(Graph g, int v, int u) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w, u);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        Cycle cycle = new Cycle(graph);
        System.out.println(cycle.hasCycle);

    }
}
