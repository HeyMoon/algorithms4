package com.dyh.algorithms4.chapter2.exercise2_5;

import com.dyh.algorithms4.StdIn;
import com.dyh.algorithms4.StdOut;

import java.util.Arrays;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/8 21:39
 * @description: 2.5.12
 */
public class SPT {

    static class Job implements Comparable<Job> {

        private String jobName;

        private int time;

        public Job(String jobName, int time) {
            this.jobName = jobName;
            this.time = time;
        }

        @Override
        public int compareTo(Job j2) {
            if (this.time > j2.time) {
                return 1;
            } else if (this.time < j2.time) {
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "jobName='" + jobName + '\'' +
                    ", time=" + time +
                    '}';
        }
    }


    public static void main(String[] args) {
        System.out.println("enter number of jobs:");
        int n = StdIn.readInt();
        System.out.println(n);

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            String name = StdIn.readString();
            int time = StdIn.readInt();
            jobs[i] = new Job(name, time);
        }

        Arrays.sort(jobs);

        for (int i = 0; i < n; i++) {
            System.out.println(jobs[i]);
        }

    }

}
