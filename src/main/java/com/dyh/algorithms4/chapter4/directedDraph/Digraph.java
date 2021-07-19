package com.dyh.algorithms4.chapter4.directedDraph;

import com.dyh.algorithms4.chapter1.Bag;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/19 22:30
 * @description:
 */
public class Digraph {

    private final int v;
    private int e;
    private Bag<Integer>[] adj;

    public Digraph(int v) {
        this.v = v;
        this.e = 0;
        this.adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag();
        }
    }

    public int v() {
        return v;
    }

    public int e() {
        return e;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        e++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph digraph = new Digraph(v);
        for (int i = 0; i < v; i++) {
            for (int w : adj(i)) {
                digraph.addEdge(w, i);
            }
        }
        return digraph;
    }

    @Override
    public String toString() {
        return v + " vertex, " + e + " edges";
    }
}
