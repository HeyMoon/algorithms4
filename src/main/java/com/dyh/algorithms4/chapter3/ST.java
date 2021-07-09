package com.dyh.algorithms4.chapter3;

public interface ST<Key extends Comparable<Key>, Value> {

    void put(Key key, Value value);

    Value get(Key key);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    Key min();

    Key max();

    /**
     * 小于等于 Key 的最大键
     *
     * @param key
     * @return
     */
    Key floor(Key key);

    /**
     * 大于等于 key 的最小键
     *
     * @param key
     * @return
     */
    Key ceiling(Key key);

    /**
     * 小于 key 的键的数量
     *
     * @param key
     * @return
     */
    int rank(Key key);

    /**
     * 排名为 k 的键
     *
     * @param k
     * @return
     */
    Key select(int k);

    void deleteMin();

    void deleteMax();

    int size(Key low, Key high);

    Iterable<Key> keys(Key low, Key high);

    Iterable<Key> keys();


}
