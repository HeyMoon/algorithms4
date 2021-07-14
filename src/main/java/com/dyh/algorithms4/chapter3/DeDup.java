package com.dyh.algorithms4.chapter3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/14 21:51
 * @description:
 */
public class DeDup {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (!set.contains(key)) {
                set.add(key);
                StdOut.println(key);
            }
        }
    }
}
