package com.dyh.algorithms4.chapter1;

/**
 * author: dengyunhui
 * datetime: 2021/6/28 21:03
 */
public class WeightedPathCompressionQuickUnionUF implements UF {

    private int[] id;
    private byte[] rank; //树的高度
    private int count;

    public WeightedPathCompressionQuickUnionUF(int count) {
        this.count = count;
        id = new int[count];
        rank = new byte[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
            rank[i] = 0;
        }
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        //将高度小的树 指向 高度大的树
        // make root of smaller rank point to root of larger rank
        if (rank[rootP] < rank[rootQ]) {
            id[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]) {
            id[rootQ] = rootP;
        } else {
            id[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]]; // path compression by halving(二等分，减半)
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
