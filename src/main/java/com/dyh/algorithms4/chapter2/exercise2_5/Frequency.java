package com.dyh.algorithms4.chapter2.exercise2_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/7 23:34
 * @description: 2.5.8
 */
public class Frequency {


    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        Arrays.sort(a);

        Record[] records = new Record[n];
        String word = a[0];
        int freq = 1;
        int m = 0;
        for (int i = 1; i < n; i++) {
            if (!a[i].equals(word)) {
                records[m++] = new Record(word, freq);
                word = a[i];
                freq = 0;
            }
            freq++;
        }
        records[m++] = new Record(word, freq);

        // sort by frequency and print results
        Arrays.sort(records, 0, m);
        for (int i = m - 1; i >= 0; i--)
            StdOut.println(records[i]);
    }

    static class Record implements Comparator<Record> {
        String word;
        int freq;

        public Record(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }

        @Override
        public int compare(Record record1, Record record2) {
            return record1.freq - record2.freq;
        }
    }
}
