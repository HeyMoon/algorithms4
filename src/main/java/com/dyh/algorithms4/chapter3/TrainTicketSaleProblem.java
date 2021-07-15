package com.dyh.algorithms4.chapter3;

import edu.princeton.cs.algs4.SparseVector;

import java.util.HashMap;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/15 00:38
 * @description: 用 稀疏矩阵 解决火车票售卖问题
 */
public class TrainTicketSaleProblem {

    /**
     * 火车有多个站，我们假设有 N 个座位， M 个站台 (N 远远大于 M)
     * int[][] seats = new int[N][M];
     * <p>
     * 所以其实买票就是 矩阵 和 列向量 的乘法（矩阵 * 列向量），但是所需的时间和 N * M 成正比，因为 M 维结果向量中的每项都需要计算 N 次 乘法。
     * 因为需要存储整个矩阵，所以所需空间也和 N * M 成正比。
     * <p>
     * 但是，这里的矩阵常常是稀疏的，即其中大多数项都是 0。
     * <p>
     * 我们假设有 5 个座位，4 个站台，用矩阵表示为 A
     * <p>
     * [0 0 0 0]
     * [0 0 0 0]
     * [0 0 0 0]
     * [0 0 0 0]
     * [0 0 0 0]
     * <p>
     * 初始的时候，肯定都是 0,如上所示。这时候张三想买一张从第一站到第三站的票，怎么判断是否有座位没人做呢？张三买票的行为我们可以表示为：
     * [1
     * 1
     * 1
     * 0]  这个列向量 B。
     * <p>
     * 所以其实我们只需要将 A 中的每一行和 B 这个列向量相乘，如果结果大于 1 则表示这个座位有人坐了。如果结果等于 0 则表示这个座位没人坐
     */

    private SparseNMMatrix matrix;

    private int n; // 一列火车有多少座位或者说一列火车可以卖的票数

    private int m; // 一列火车经过多少站台

    private HashMap<String, Integer> stationsMap;

    public TrainTicketSaleProblem(int n, String[] stations) {
        this.n = n;
        this.m = stations.length;
        this.stationsMap = new HashMap<>(stations.length);
        for (int i = 0; i < stations.length; i++) {
            stationsMap.put(stations[i], i);
        }

        matrix = new SparseNMMatrix(n, this.m);
    }

    /**
     * @param startStation 想买的票的起始站
     * @param endStation   想买的票的终点站
     */
    private void sale(String startStation, String endStation) {
        System.out.println("----start: " + startStation + " ,end: " + endStation);
        int startIndex = stationsMap.get(startStation);
        int endIndex = stationsMap.get(endStation);

        SparseVector x = new SparseVector(m);
        // 构造列向量，终点站不用设置为 1,设置为 0 即可。
        for (int i = startIndex; i < endIndex; i++) {
            x.put(i, 1.0);
        }

        int i;
        boolean found = false;
        for (i = 0; i < n - 1; i++) {
            double result = matrix.rows[i].dot(x);
            if (result == 0.0) {
                // 找到了座位
                found = true;
                System.out.println("found seat: " + i);
                break;
            }
        }

        if (found) {
            // 将矩阵中的相应位置置为 1.0，表示座位已经售出
            for (int j = startIndex; j < endIndex; j++) {
                System.out.println("put i :" + i + " ,j: " + j);
                matrix.put(i, j, 1.0);
            }
        }
        System.out.println("end----start: " + startStation + " ,end: " + endStation);
    }


    public static void main(String[] args) {
        String[] STATIONS = new String[]{"A", "B", "C", "D", "E", "F", "H", "I"};
        TrainTicketSaleProblem trainTicketSale = new TrainTicketSaleProblem(10, STATIONS);
        trainTicketSale.sale("A", "B");
        trainTicketSale.sale("A", "C");
        trainTicketSale.sale("A", "D");
        trainTicketSale.sale("A", "E");
        trainTicketSale.sale("A", "F");
        trainTicketSale.sale("A", "H");
        trainTicketSale.sale("A", "I");
        trainTicketSale.sale("B", "C");
        trainTicketSale.sale("B", "D");
        trainTicketSale.sale("B", "E");
        //没有票卖了
        trainTicketSale.sale("B", "F"); // 如果改成 D - F 就有票卖

        trainTicketSale.sale("B", "H");
    }

}
