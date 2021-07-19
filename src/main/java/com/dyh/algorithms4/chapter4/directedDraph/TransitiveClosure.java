package com.dyh.algorithms4.chapter4.directedDraph;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/20 00:00
 * @description:
 */
public class TransitiveClosure {

    private DirectedDFS[] all;

    public TransitiveClosure(Digraph g) {
        all = new DirectedDFS[g.v()];
        for (int i = 0; i < g.v(); i++) {
            all[i] = new DirectedDFS(g, i);
        }
    }

    /**
     * w 是从 v 可达的吗
     *
     * @param v
     * @param w
     * @return
     */
    public boolean reachable(int v, int w) {
        return all[v].marked(w);
    }

}
