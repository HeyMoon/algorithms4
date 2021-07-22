package com.dyh.algorithms4.chapter5;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/22 23:39
 * @description:
 */
public class RabinKarp {

    private String pat; // 模式字符串,仅拉斯维加斯算法需要
    private long patHash; // 模式字符串的散列值
    private int M; // 模式字符串的长度
    private long Q; // 一个很大的素数
    private int R = 256; // 字母表大小
    private long RM; // R ^ (M-1) % Q

    public RabinKarp(String pat) {
        this.pat = pat;
        this.M = pat.length();
        Q = longRandomPrime();
        RM = 1;
        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;
        }

        patHash = hash(pat, M);
    }

    private long hash(String key, int m) {
        long h = 0;
        for (int j = 0; j < m; j++)
            h = (R * h + key.charAt(j)) % Q;

        return h;
    }

    private long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public int search(String txt) {
        int N = txt.length();
        long txtHash = hash(txt, M);
        if (patHash == txtHash && check(txt, 0)) {
            return 0;
        }

        for (int i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if (patHash == txtHash) {
                if (check(txt, i - M + 1)) {
                    return i - M + 1;
                }
            }
        }

        return N;
    }

    private boolean check(String txt, int i) {
        for (int j = 0; j < M; j++)
            if (pat.charAt(j) != txt.charAt(i + j))
                return false;
        return true;
    }

}
