package com.dyh.algorithms4.chapter3;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/14 21:19
 * @description:
 */
public class SeparateChainingHashST<Key, Value> {

    private static final int DEFAULT_CAPACITY = 16;

    private int size;

    private int m;

    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(DEFAULT_CAPACITY);
    }

    public SeparateChainingHashST(int m) {
        this.m = m;
        st = new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    /**
     * 返回 0 到 m-1 之间的数，也就是 key 在数组中的下标
     *
     * @param key
     * @return
     */
    private int hash(Key key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (m - 1);
    }

}
