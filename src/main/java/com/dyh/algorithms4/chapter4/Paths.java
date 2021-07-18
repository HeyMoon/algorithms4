package com.dyh.algorithms4.chapter4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/16 20:38
 * @description:
 */
public class Paths {


    /**
     * 在 G 中找出所有起点为 s 的路径
     *
     * @param g
     * @param s
     */
    public Paths(Graph g, int s) {

    }

    /**
     * 是否存在从 s 到 v 的路径
     *
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return false;
    }

    /**
     * s 到 v 的路径，如果不存在则返回 null
     *
     * @param v
     * @return
     */
    public Iterable<Integer> pathTo(int v) {

        return null;
    }

    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);

        Paths search = new Paths(g, s);
        for (int i = 0; i < g.vertex(); i++) {
            StdOut.print(s + " to " + i + " : ");

            if (search.hasPathTo(i)) {
                for (int x : search.pathTo(i)) {
                    if (x == s) {
                        StdOut.print(x);
                    } else {
                        StdOut.print("-" + x);
                    }
                }
            }

            StdOut.println();
        }
    }

}
