package com.dyh.algorithms4.chapter2.exercise2_4;

import com.dyh.algorithms4.chapter2.MaxPQ;
import com.dyh.algorithms4.chapter2.MinPQ;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/7 22:41
 * @description: 2.4.30 动态中位数查找
 */
public class DynamicMedianFinding<Key extends Comparable<Key>> {

    /**
     * 当前中位数
     */
    private Key median;

    private boolean islt = false;

    /**
     * 小于中位数的元素
     */
    private MaxPQ lt;

    /**
     * 大于中位数的元素
     */
    private MinPQ gt;

    private int count;

    public DynamicMedianFinding(int n) {
        lt = new MaxPQ(n + 1);
        gt = new MinPQ(n + 1);
        count = 0;
    }

    public void insert(Key key) {
        if (count == 0) {
            median = key;
            islt = true;
            lt.insert(key);
        } else {
            int cmp = key.compareTo(median);
            if (cmp > 0) {
                gt.insert(key);
            } else if (cmp <= 0) {
                lt.insert(key);
            }
            determineMedian();
        }
        count++;
    }

    private void determineMedian() {
        //保证两个 heap 的元素只差 <= 1
        if (lt.size() > gt.size() + 1) {
            gt.insert(lt.delMax());
        } else if (gt.size() > lt.size() + 1) {
            lt.insert(gt.delMin());
        }

        if (lt.size() >= gt.size()) {
            median = (Key) lt.max();
            islt = true;
        } else {
            median = (Key) gt.min();
            islt = false;
        }
    }

    public Key findMedian() {
        return median;
    }

    public Key deleteMedian() {
        Key v = median;
        if (islt) {
            lt.delMax();
        } else {
            gt.delMin();
        }
        determineMedian();
        return v;
    }

    public static void main(String[] args) {
        String[] strings = {"A", "B", "C", "D", "H", "F", "G", "J", "O", "P"};
        DynamicMedianFinding findMedian = new DynamicMedianFinding(strings.length);
        for (String s : strings) {
            findMedian.insert(s);
        }

        System.out.println("median:" + findMedian.findMedian());
        System.out.println("delete median:" + findMedian.deleteMedian());
        System.out.println("median:" + findMedian.findMedian());

    }

}
