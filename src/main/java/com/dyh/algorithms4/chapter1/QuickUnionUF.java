package com.dyh.algorithms4.chapter1;

/**
 * user: dengyunhui
 * datetime: 2021/6/28 20:38
 */
public class QuickUnionUF implements UF {

    private int[] id;
    private int count;

    public QuickUnionUF(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }


    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot) {
            return;
        }

        id[pRoot] = qRoot;
        count--;
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }

        return p;
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
