package com.dyh.algorithms4.chapter1;

/**
 * user: dengyunhui
 * datetime: 2021/6/28 20:37
 */
public class QuickFindUF implements UF {

    private int[] id;
    private int count;

    public QuickFindUF(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }


    @Override
    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);

        if (pid == qid) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }

        count--;
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }


}
