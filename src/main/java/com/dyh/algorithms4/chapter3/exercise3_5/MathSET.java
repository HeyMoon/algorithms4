package com.dyh.algorithms4.chapter3.exercise3_5;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/14 23:11
 * @description: 3.5.17
 */
public class MathSET<Key> {

    private boolean[] set;

    private int size;

    public MathSET() {
        this(16);
    }

    public MathSET(int capacity) {
        set = new boolean[capacity];
        for (int i = 0; i < capacity; i++) {
            set[i] = false;
        }
    }

    public MathSET(Key[] universe) {
        set = new boolean[universe.length];
        for (Key key : universe) {
            set[hash(key)] = true;
        }
    }

    public void add(Key key) {
        if (size >= set.length) {
            resize(2 * set.length);
        }

        int i = hash(key);
        set[i] = true;
        size++;
    }

    private void resize(int capacity) {
        boolean[] newSet = new boolean[capacity];
        System.arraycopy(set, 0, newSet, 0, set.length - 1);
        set = newSet;
    }

    private int hash(Key key) {
        int h = key.hashCode();
        h = h ^ (h >>> 16);
        return h & (set.length - 1);
    }

    public MathSET<Key> complement() {

        return null;
    }

    public void union(MathSET<Key> a) {

    }

    public void delete(Key key) {
        set[hash(key)] = false;
        size--;
    }

    public boolean contains(Key key) {
        return set[hash(key)];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


}
