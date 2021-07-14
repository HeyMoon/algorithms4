package com.dyh.algorithms4.chapter3;

import edu.princeton.cs.algs4.SparseVector;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/15 01:20
 * @description:
 */
public class SparseNMMatrix {

    private int n;                 // n-by-m matrix
    private int m;
    private SparseVector[] rows;   // the rows, each row is a sparse vector

    public SparseNMMatrix(int n, int m) {
        this.n = n;
        this.m = m;
        rows = new SparseVector[n];
        for (int i = 0; i < n; i++)
            rows[i] = new SparseVector(m);
    }

    // put A[i][j] = value
    public void put(int i, int j, double value) {
        if (i < 0 || i >= n) throw new IllegalArgumentException("Illegal index");
        if (j < 0 || j >= m) throw new IllegalArgumentException("Illegal index");
        rows[i].put(j, value);
    }

    // return A[i][j]
    public double get(int i, int j) {
        if (i < 0 || i >= n) throw new IllegalArgumentException("Illegal index");
        if (j < 0 || j >= m) throw new IllegalArgumentException("Illegal index");
        return rows[i].get(j);
    }

    // return the number of nonzero entries (not the most efficient implementation)
    public int nnz() {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += rows[i].nnz();
        return sum;
    }

    // return the matrix-vector product b = Ax
    public SparseVector times(SparseVector x) {
        if (m != x.size()) throw new IllegalArgumentException("Dimensions disagree");
        SparseVector b = new SparseVector(n);
        for (int i = 0; i < n; i++)
            b.put(i, rows[i].dot(x));
        return b;
    }

    // return this + that
    public SparseNMMatrix plus(SparseNMMatrix that) {
        if (this.n != that.n || this.m != that.m) throw new RuntimeException("Dimensions disagree");
        SparseNMMatrix result = new SparseNMMatrix(n, m);
        for (int i = 0; i < n; i++)
            result.rows[i] = this.rows[i].plus(that.rows[i]);
        return result;
    }


    // return a string representation
    public String toString() {
        String s = "n = " + n + ", nonzeros = " + nnz() + "\n";
        for (int i = 0; i < n; i++) {
            s += i + ": " + rows[i] + "\n";
        }
        return s;
    }


    // test client
    public static void main(String[] args) {
        SparseNMMatrix A = new SparseNMMatrix(6, 5);
        SparseVector x = new SparseVector(5);
        A.put(0, 0, 1.0);
        A.put(1, 1, 1.0);
        A.put(2, 2, 1.0);
        A.put(3, 3, 1.0);
        A.put(4, 4, 1.0);
        A.put(2, 4, 0.3);

        x.put(0, 0.75);
        x.put(2, 0.11);

        StdOut.println("x     : " + x);
        StdOut.println("A     : " + A);
        StdOut.println("Ax    : " + A.times(x));
        StdOut.println("A + A : " + A.plus(A));
    }

}
