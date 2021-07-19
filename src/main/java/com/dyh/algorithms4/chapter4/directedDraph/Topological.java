package com.dyh.algorithms4.chapter4.directedDraph;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/19 23:35
 * @description: 拓扑排序.解决优先级限制下的调度问题
 * <p>
 * 当且仅当一幅有向图是无环图是才能进行拓扑排序
 * <p>
 * 一副有向无环图的拓扑排序即为所有顶点的逆后序排列
 */
public class Topological {

    private Iterable<Integer> order;

    public Topological(Digraph g) {
        DirectedCycle cyclefinder = new DirectedCycle(g);
        if (cyclefinder.hasCycle()) {
            return;
        }

        DepthFirstOrder dfs = new DepthFirstOrder(g);
        this.order = dfs.reversePost();
    }

    /**
     * 是否是有向无环图（ DAG )
     *
     * @return
     */
    public boolean isDAG() {
        return order != null;
    }

    public Iterable<Integer> order() {
        return order;
    }

}
