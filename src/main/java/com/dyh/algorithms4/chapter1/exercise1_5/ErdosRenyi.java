package com.dyh.algorithms4.chapter1.exercise1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import com.dyh.algorithms4.chapter1.WeightedPathCompressionQuickUnionUF;

/**
 * author: dengyunhui
 * datetime: 2021/6/28 21:57
 */
public class ErdosRenyi {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedPathCompressionQuickUnionUF uf = new WeightedPathCompressionQuickUnionUF(n);
        System.out.println("n:" + n);

        while (uf.count() > 1) {
            int p = StdRandom.uniform(n);
            int q = StdRandom.uniform(n);

            if (!uf.connected(p, q)) {
                System.out.println("p:" + p + ",q:" + q);
                uf.union(p, q);
            }
        }

        System.out.println("count:" + uf.count());
    }
}
