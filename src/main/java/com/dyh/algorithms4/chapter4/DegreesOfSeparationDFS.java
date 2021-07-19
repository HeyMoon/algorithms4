package com.dyh.algorithms4.chapter4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/19 22:05
 * @description:
 */
public class DegreesOfSeparationDFS {

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        String source = args[2];

        // StdOut.println("Source: " + source);

        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.graph();
        if (!sg.contains(source)) {
            StdOut.println(source + " not in database.");
            return;
        }

        int s = sg.index(source);
        DepthFirstPaths bfs = new DepthFirstPaths(G, s);

        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if (sg.contains(sink)) {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t)) {
                    for (int v : bfs.pathTo(t)) {
                        StdOut.println("   " + sg.name(v));
                    }
                } else {
                    StdOut.println("Not connected");
                }
            } else {
                StdOut.println("   Not in database.");
            }
        }
    }

}