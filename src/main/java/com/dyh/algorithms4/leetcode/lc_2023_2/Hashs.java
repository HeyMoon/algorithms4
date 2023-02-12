package com.dyh.algorithms4.leetcode.lc_2023_2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: dengyunhui
 * @datetime: 2023/1/30 下午4:36
 * @description:
 */
public class Hashs {

    public static void main(String[] args) {


    }

    public boolean isAnagram(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];

        for (char ch : s.toCharArray()) {
            sCount[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            tCount[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sCount[i] != tCount[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        int[] sCount = new int[26];

        for (char ch : s.toCharArray()) {
            sCount[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            sCount[ch - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (sCount[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int s1: nums1) {
            set1.add(s1);
        }

        for (int s2 : nums2) {
            if (set1.contains(s2)){
                set2.add(s2);
            }
        }

        return set2.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] twoSum(int[] nums, int target) {

        return null;
    }

}
