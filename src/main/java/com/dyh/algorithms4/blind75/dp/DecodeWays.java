package com.dyh.algorithms4.blind75.dp;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/11 上午10:51
 * @description:
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            if (i > 1
                    && s.charAt(i - 2) != '0'
                    && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] += dp[i - 2];
            }

        }

        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        /*System.out.println(decodeWays.numDecodings("12"));
        System.out.println(decodeWays.numDecodings("226"));
        System.out.println(decodeWays.numDecodings("0"));
        System.out.println(decodeWays.numDecodings("10"));
        System.out.println(decodeWays.numDecodings("27"));
        System.out.println(decodeWays.numDecodings("06"));
        System.out.println(decodeWays.numDecodings("2101"));*/
        System.out.println(decodeWays.numDecodings("301"));
    }
}
