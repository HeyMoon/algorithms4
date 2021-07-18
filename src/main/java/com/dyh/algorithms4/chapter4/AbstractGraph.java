package com.dyh.algorithms4.chapter4;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/15 21:24
 * @description:
 */
public abstract class AbstractGraph {

    abstract public int vertex();

    abstract public int edge();

    abstract public void addEdge(int v, int w);

    abstract public Iterable<Integer> adj(int v);

    /**
     * 计算 v 的度数
     *
     * @param g
     * @param v
     * @return
     */
    public static int degree(AbstractGraph g, int v) {
        int degree = 0;
        for (int w : g.adj(v)) {
            degree++;
        }
        return degree;
    }

    /**
     * 计算所有顶点的最大度数
     *
     * @param g
     * @return
     */
    public static int maxDegree(AbstractGraph g) {
        int max = 0;
        for (int v = 0; v < g.vertex(); v++) {
            if (degree(g, v) > max) {
                max = degree(g, v);
            }
        }
        return max;
    }

    /**
     * 平均度数
     *
     * @param g
     * @return
     */
    public static double avgDegree(AbstractGraph g) {
        return 2 * g.edge() / g.vertex();
    }

    public static int numberOfSelfLoops(AbstractGraph g) {
        int count = 0;
        for (int i = 0; i < g.vertex(); i++) {
            for (int w : g.adj(i)) {
                if (i == w) {
                    count++;
                }
            }
        }
        return count / 2;
    }

    @Override
    public String toString() {
        String s = vertex() + " vertices, " + edge() + " edges\n";
        for (int i = 0; i < vertex(); i++) {
            s += i + ": ";
            for (int w : this.adj(i)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }


}
