package com.dyh.algorithms4.chapter1;

/**
 * author: dengyunhui
 * datetime: 2021/6/28 22:54
 */
public class QuickUnionPathComperssionUF implements UF {

    private int[] id;
    private int count;

    public QuickUnionPathComperssionUF(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        id[rootP] = rootQ;
        count--;
    }

    @Override
    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }

        while (p != root) {
            int parent = id[p];
            id[p] = root;
            p = parent;
        }

        return root;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
