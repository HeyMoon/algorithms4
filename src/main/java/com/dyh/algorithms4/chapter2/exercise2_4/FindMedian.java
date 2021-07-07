package com.dyh.algorithms4.chapter2.exercise2_4;

import com.dyh.algorithms4.chapter2.MaxPQ;
import com.dyh.algorithms4.chapter2.MinPQ;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/7 22:41
 * @description: 2.4.30 动态中位数查找
 */
public class FindMedian<Key extends Comparable<Key>> {

    /**
     * 当前中位数
     */
    private Key median;

    /**
     * 小于中位数的元素
     */
    private MaxPQ lt;

    /**
     * 大于中位数的元素
     */
    private MinPQ gt;

    private int count;

    public void insert(Key key) {
        if (count == 0) {
            median = key;
        } else {
            int cmp = key.compareTo(median);
            if (cmp > 0) {
                gt.insert(key);
            } else if (cmp <= 0) {
                lt.insert(key);
            }
        }
    }

    public Key findMedian() {
        return median;
    }

    public Key deleteMedian() {
        Key v = median;

        if (!lt.isEmpty() && !gt.isEmpty()) {
            int cmp = lt.max().compareTo(gt.min());
            if (cmp > 0) {
                median = (Key) gt.delMin();
            } else if (cmp < 0) {
                median = (Key) lt.delMax();
            }
        } else if (lt.isEmpty()) {
            median = (Key) gt.delMin();
        } else if (gt.isEmpty()) {
            median = (Key) lt.delMax();
        }

        return v;
    }



}
