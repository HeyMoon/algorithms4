package com.dyh.algorithms4.chapter3;

import java.util.HashMap;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/14 22:28
 * @description:
 */
public class SparseVector {

    private HashMap<Integer, Double> st;

    public SparseVector() {
        st = new HashMap<>();
    }

    public int size() {
        return st.size();
    }

    public void put(int i, double x) {
        st.put(i, x);
    }

    public double get(int i) {
        if (!st.containsKey(i)) {
            return 0.0;
        }

        return st.get(i);
    }

    public double dot(double[] that) {
        double sum = 0.0;
        for (int i : st.keySet()) {
            sum += that[i] * this.get(i);
        }
        return sum;
    }


}
