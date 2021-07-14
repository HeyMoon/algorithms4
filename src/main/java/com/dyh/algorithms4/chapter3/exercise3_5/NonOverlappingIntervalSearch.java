package com.dyh.algorithms4.chapter3.exercise3_5;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/14 23:29
 * @description: 3.5.24 不重叠的区间查找
 */
public class NonOverlappingIntervalSearch<Key> {

    private boolean[] set;

    private int size;

    public NonOverlappingIntervalSearch() {
        this(16);
    }

    public NonOverlappingIntervalSearch(int capacity) {
        set = new boolean[capacity];
        for (int i = 0; i < capacity; i++) {
            set[i] = false;
        }
    }

    public void add(int[] key) {
        if (size >= set.length) {
            resize(2 * set.length);
        }

        int key1 = key[0];
        int key2 = key[1];

        int i1 = hash(key1);
        int i2 = hash(key2);
        int begin = i1 > i2 ? i2 : i1;
        int end = i1 > i2 ? i1 : i2;

        for (int i = begin; i <= end; i++) {
            set[i] = true;
        }

        size = size + 2;
    }

    private void resize(int capacity) {
        boolean[] newSet = new boolean[capacity];
        System.arraycopy(set, 0, newSet, 0, set.length - 1);
        set = newSet;
    }

    private int hash(int key) {
        int h = key;
        h = h ^ (h >>> 16);
        return h & (set.length - 1);
    }

    public void delete(int key) {
        set[hash(key)] = false;
        size--;
    }

    public boolean contains(int key) {
        return set[hash(key)];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    /**
     * 因为区间是互不重叠的，所以可以这样做
     * 将区间的开始 hash 得到 beginIndex,区间的结束 hash 得到 endIndex
     * 将 beginIndex 到 endIndex 中的所有 index 都设置为 true
     *
     * @param args
     */
    public static void main(String[] args) {
        NonOverlappingIntervalSearch set = new NonOverlappingIntervalSearch(10000000);
        // 1643 - 2033
        set.add(new int[]{1643, 2033});

        // 5532 - 7643
        set.add(new int[]{5532, 7643});

        // 8999 - 10332
        set.add(new int[]{8999, 10332});

        System.out.println(set.contains(9122));
        System.out.println(set.contains(8122));


    }
}
