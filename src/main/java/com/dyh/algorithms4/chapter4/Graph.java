package com.dyh.algorithms4.chapter4;

import com.dyh.algorithms4.chapter1.Bag;
import com.dyh.algorithms4.chapter1.ResizingArrayStack;
import com.dyh.algorithms4.chapter1.Stack;
import edu.princeton.cs.algs4.In;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/15 22:03
 * @description:
 */
public class Graph extends AbstractGraph {

    private final int v;  // 顶点数目
    private int e;       // 边的数目
    private Bag<Integer>[] adj; // 邻接表，保存每个顶点的所有相邻顶点

    public Graph(int v) {
        this.v = v;
        this.e = 0;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public Graph(Graph g) {
        this.v = g.v;
        this.e = g.e;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }

        for (int i = 0; i < g.v; i++) {
            Stack<Integer> reverse = new ResizingArrayStack<>();

            for (int w : g.adj(i)) {
                reverse.push(w);
            }

            for (int w : reverse) {
                this.adj[i].add(w);
            }
        }
    }

    public boolean hasEdge(int v, int w) {
        for (int t : this.adj(v)) {
            if (t == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int vertex() {
        return v;
    }

    @Override
    public int edge() {
        return e;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w); // 将 w 添加到 v 的链表中
        adj[w].add(v); // 将 v 添加到 w 的链表中
        e++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
