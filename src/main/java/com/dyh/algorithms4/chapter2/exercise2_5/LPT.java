package com.dyh.algorithms4.chapter2.exercise2_5;

import edu.princeton.cs.algs4.StdIn;
import com.dyh.algorithms4.chapter2.MinPQ;

import java.util.Arrays;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/8 21:56
 * @description:
 */
public class LPT {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);

        System.out.println("enter number of jobs:");
        int n = StdIn.readInt();
        System.out.println(n);

        SPT.Job[] jobs = new SPT.Job[n];
        for (int i = 0; i < n; i++) {
            String name = StdIn.readString();
            int time = StdIn.readInt();
            jobs[i] = new SPT.Job(name, time);
        }

        //sort jobs in asc order of processing time
        Arrays.sort(jobs);

        MinPQ minPQ = new MinPQ<>(m);
        for (int i = 0; i < m; i++) {
            minPQ.insert(new Process());
        }

        for (int i = n - 1; i > 0; i--) {
            Process min = (Process) minPQ.delMin();
            min.add(jobs[i]);
            minPQ.insert(min);
        }

    }


    static class Process implements Comparable {
        private SPT.Job job;

        public void add(SPT.Job job) {
            this.job = job;
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}
