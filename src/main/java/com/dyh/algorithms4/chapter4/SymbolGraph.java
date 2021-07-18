package com.dyh.algorithms4.chapter4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/18 23:22
 * @description:
 */
public class SymbolGraph {

    private ST<String, Integer> st; // 符号名 -> 索引
    private String[] keys; // 索引 -> 符号名
    private Graph g; // 图


    public SymbolGraph(String filename, String delim) {
        st = new ST();
        In in = new In(filename);  // 第一遍
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delim); // 读取字符串

            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i])) {      // 为每个不同的字符串关联一个索引
                    st.put(a[i], st.size());
                }
            }
        }

        keys = new String[st.size()]; // 用来获得顶点名的反向索引是一个数组
        for (String key : st.keys()) {
            keys[st.get(key)] = key;
        }

        g = new Graph(st.size());
        in = new In(filename); // 构造图
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delim); // 将每一行的顶点和该行的其他顶点相连
            String v1 = a[0];
            int i1 = st.get(v1);

            for (int i = 1; i < a.length; i++) {
                String v = a[i];
                int vIndex = st.get(v);
                g.addEdge(i1, vIndex);
            }
        }
    }

    /**
     * key 是一个顶点吗
     *
     * @param key
     * @return
     */
    public boolean contains(String key) {
        return st.contains(key);
    }


    /**
     * key 的索引
     *
     * @param key
     * @return
     */
    public int index(String key) {
        return st.get(key);
    }

    /**
     * 索引 v 的顶点
     *
     * @param v
     * @return
     */
    public String name(int v) {
        return keys[v];
    }

    public Graph graph() {
        return g;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delim = args[1];
        SymbolGraph sg = new SymbolGraph(filename, delim);
        Graph g = sg.graph();
        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            for (int w : g.adj(sg.index(source))) {
                StdOut.println("   " + sg.name(w));
            }
        }
    }

}
