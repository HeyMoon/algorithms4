package com.dyh.algorithms4.leetcode;

/**
 * @author: dengyunhui
 * @datetime: 2021/8/18 20:46
 * @description:
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] occur = new int[256];
        for (int i = 0; i < 256; i++) {
            occur[i] = -1;
        }

        int begin = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            begin = Math.max(begin, occur[c] + 1);
            length = Math.max(length, i - begin + 1);
            occur[c] = i;
        }

        return length;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring(" "));
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("bfbv"));
    }

}
