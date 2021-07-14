package com.dyh.algorithms4.chapter3;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/14 23:05
 * @description:
 */
public class LinearProbingHashST<Key, Value> {

    private static final int DEFAULT_CAPACITY = 16;

    private Key[] keys;
    private Value[] values;

    private int size;


    public LinearProbingHashST() {
        this(DEFAULT_CAPACITY);
    }

    public LinearProbingHashST(int capacity) {
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
        size = 0;
    }

    public void put(Key key, Value value) {
        int index = hash(key);
        int i;
        for (i = index; keys[i] != null; i = (i + 1) % keys.length) {
            if (keys[i] == key) {
                values[i] = value;
                return;
            }
        }

        keys[i] = key;
        values[i] = value;
        size++;
    }

    public Value get(Key key) {
        int index = hash(key);
        for (int i = index; keys[i] != null; i = (i + 1) % keys.length) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }

        return null;
    }

    private int hash(Key key) {
        int hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12) ^ (hash >>> 7) ^ (hash >>> 4);
        return hash & (keys.length - 1);
    }

}
