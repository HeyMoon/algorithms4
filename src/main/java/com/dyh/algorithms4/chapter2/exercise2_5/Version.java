package com.dyh.algorithms4.chapter2.exercise2_5;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/8 21:32
 * @description: 2.5.10
 */
public class Version implements Comparable<Version> {

    private int majorVersion;

    private int minorVersion;

    private int maintainVersion;

    public Version(int majorVersion, int minorVersion, int maintainVersion) {
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.maintainVersion = maintainVersion;
    }

    @Override
    public int compareTo(Version version) {
        return 0;
    }
}
