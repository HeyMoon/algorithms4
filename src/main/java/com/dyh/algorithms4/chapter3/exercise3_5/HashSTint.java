package com.dyh.algorithms4.chapter3.exercise3_5;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/14 22:44
 * @description:
 */
public class HashSTint {

    private int[] keys;

    private int[] values;

    private int size;

    private static final int DEFAULT_CAPACITY = 16;

    public HashSTint() {
        this(DEFAULT_CAPACITY);
    }

    public HashSTint(int capacity) {
        keys = new int[capacity];
        values = new int[capacity];
    }

    public void put(int key, int value) {
        int index = hash(key);
        int i;
        for (i = index; keys[i] != 0; i = (i + 1) % keys.length) {
            if (keys[i] == key) {
                values[i] = value;
                return;
            }
        }

        keys[i] = key;
        values[i] = value;
        size++;
    }

    public int get(int key) {
        int index = hash(key);
        for (int i = index; keys[i] != 0; i = (i + 1) % keys.length) {
            if (keys[i] == key) {
                return values[i];
            }
        }

        return 0;
    }

    private int hash(int key) {
        int hash = key;
        hash ^= (hash >>> 20) ^ (hash >>> 12) ^ (hash >>> 7) ^ (hash >>> 4);
        return hash & (keys.length - 1);
    }

}
