package com.dyh.algorithms4.chapter3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/9 22:25
 * @description:
 */
public class BinarySearchBT<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    private int count;

    private Key[] keys;

    private Value[] values;

    public BinarySearchBT(int capacity) {
        this.count = 0;
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    @Override
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < count && key.compareTo(keys[i]) == 0) {
            values[i] = value;
            return;
        }

        if (isFull()) {
            resize(2 * count);
        }

        for (int j = count; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[i] = key;
        values[i] = value;
        count++;
    }

    private void resize(int newCapacity) {
        Key[] newKey = (Key[]) new Comparable[newCapacity];
        Value[] newValues = (Value[]) new Object[newCapacity];

        System.arraycopy(keys, 0, newKey, 0, count);
        System.arraycopy(values, 0, newValues, 0, count);

        keys = newKey;
        values = newValues;
    }

    private boolean isFull() {
        return count >= keys.length - 1;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);
        if (i < count && keys[i].compareTo(key) == 0) {
            return values[i];
        }

        return null;
    }

    @Override
    public void delete(Key key) {
        int i = rank(key);
        if (i < count && keys[i].compareTo(key) == 0) {
            for (int j = i; j < count - 1; j++) {
                keys[j] = keys[j + 1];
                values[j] = values[j + 1];
            }

            count--;
            keys[count] = null;
            values[count] = null;

            if (count > 0 && count == keys.length / 4) {
                resize(keys.length / 2);
            }
        }

    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[count - 1];
    }

    @Override
    public Key floor(Key key) {
        int i = rank(key);
        return keys[i - 1];
    }

    @Override
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    @Override
    public int rank(Key key) {
        int low = 0, high = count - 1;
        while (high >= low) {
            int mid = low + (high - low) / 2;
            int cmp = keys[mid].compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return low;
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public void deleteMin() {
        delete(min());
    }

    @Override
    public void deleteMax() {
        delete(max());
    }

    @Override
    public int size(Key low, Key high) {
        if (low.compareTo(high) > 0) return 0;
        if (contains(high)) return rank(high) - rank(low) + 1;
        else return rank(high) - rank(low);
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<>();
        if (lo.compareTo(hi) > 0) return queue;
        for (int i = rank(lo); i < rank(hi); i++)
            queue.add(keys[i]);
        if (contains(hi)) queue.add(keys[rank(hi)]);
        return queue;
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < count; i++) {
            stringBuffer.append("key:").append(keys[i]).append(",value:").append(values[i]).append("\n");
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        BinarySearchBT binarySearchBT = new BinarySearchBT(4);
        binarySearchBT.put("A+", 4.33);
        binarySearchBT.put("A", 4.00);
        binarySearchBT.put("A-", 3.67);
        binarySearchBT.put("B+", 3.33);
        binarySearchBT.put("B", 3.00);
        binarySearchBT.put("B-", 2.67);
        binarySearchBT.put("C+", 2.33);
        binarySearchBT.put("C", 2.00);
        binarySearchBT.put("C-", 1.67);
        binarySearchBT.put("D", 1.00);
        binarySearchBT.put("F", 0.00);

        System.out.println(binarySearchBT);
    }
}
