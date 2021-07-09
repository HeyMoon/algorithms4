package com.dyh.algorithms4.chapter2.exercise2_5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/8 22:10
 * @description:
 */
public class California {

    public static void main(String[] args) {
        Nominee nominee1 = new Nominee("JOHN WICK");
        Nominee nominee2 = new Nominee("HUTCH");
        Nominee nominee3 = new Nominee("DENZEL WASHINGTON");

        Nominee[] nominees = new Nominee[]{nominee1, nominee2, nominee3};
        Arrays.sort(nominees);

        for (int i = 0; i < nominees.length; i++) {
            System.out.println(nominees[i]);
        }

    }


    public static List<String> CHARACTER = Arrays.asList("R", "W", "Q", "O", "J", "M", "V", "A", "H", "B", "S", "G", "Z", "X", "N", "T", "C", "I", "E", "K", "U", "P", "D", "Y", "F", "L");

    private static int getIndex(List<String> ch, String first){
        return 0;
    }

    static class Nominee implements Comparable<Nominee> {
        private String name;

        private String first;

        public Nominee(String name) {
            this.name = name;
            this.first = name.substring(0, 1);
        }

        @Override
        public int compareTo(Nominee nominee) {
            int thatIndex = getIndex(CHARACTER, nominee.first);
            int thisIndex = getIndex(CHARACTER, this.first);
            if (thisIndex > thatIndex) {
                return 1;
            } else if (thisIndex < thatIndex) {
                return -1;
            }

            return 0;
        }

        @Override
        public String toString() {
            return "Nominee{" +
                    "name='" + name + '\'' +
                    ", first='" + first + '\'' +
                    '}';
        }
    }


}
