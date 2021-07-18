package com.dyh.algorithms4.chapter4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/15 22:20
 * @description:
 */
public class TestSearch {

    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        Search search = new DepthFirstSearch(g, s);
        for (int i = 0; i < g.vertex(); i++) {
            if (search.marked(i)) {
                StdOut.print(i + " ");
            }
            StdOut.println();
        }

        if (search.count() != g.vertex()) {
            StdOut.print("NOT ");
        }

        StdOut.println("connected");
    }

}
