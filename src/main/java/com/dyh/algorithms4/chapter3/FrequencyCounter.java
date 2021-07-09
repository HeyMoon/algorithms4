package com.dyh.algorithms4.chapter3;

import com.dyh.algorithms4.StdIn;
import com.dyh.algorithms4.StdOut;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/9 23:30
 * @description:
 */
public class FrequencyCounter {

    public static void main(String[] args) {
        System.out.println(String.join(",", args));
        int distinct = 0, words = 0;
        int minlen = Integer.parseInt(args[0]);
        ST<String, Integer> st = new BinarySearchBT<>(100);

        // compute frequency counts
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
                distinct++;
            }
        }

        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
    }

}
