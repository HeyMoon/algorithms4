package com.dyh.algorithms4.chapter1.exercise1_5;

import com.dyh.algorithms4.chapter1.UF;

/**
 * author: dengyunhui
 * datetime: 2021/6/28 21:35
 */
public class E1_5_11 implements UF {

    private int[] id;
    private int count;
    private int[] size;

    public E1_5_11(int count) {
        this.count = count;
        id = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
            size[i] = 0;
        }
    }

    @Override
    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) {
            return;
        }

        if (size[pid] < size[qid]) {
            //将较小的分量重命名为较大的分量
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pid) {
                    id[i] = qid;
                    size[qid]++;
                }
            }
        } else {
            //将较小的分量重命名为较大的分量
            for (int i = 0; i < id.length; i++) {
                if (id[i] == qid) {
                    id[i] = pid;
                    size[pid]++;
                }
            }
        }
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }
}
