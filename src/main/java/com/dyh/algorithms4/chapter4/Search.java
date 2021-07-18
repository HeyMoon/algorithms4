package com.dyh.algorithms4.chapter4;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/15 22:06
 * @description:
 */
public abstract class Search {

    public Search(Graph g, int s) {

    }

    abstract public boolean marked(int v);

    abstract public int count();


}
