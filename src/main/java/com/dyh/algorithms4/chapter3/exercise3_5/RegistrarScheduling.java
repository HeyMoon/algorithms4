package com.dyh.algorithms4.chapter3.exercise3_5;

import java.util.HashMap;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/14 23:51
 * @description: 3.5.25
 */
public class RegistrarScheduling {


    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("9:00", "课程1");
        hashMap.put("10:00", "课程2");
        hashMap.put("11:00", "课程3");
        hashMap.put("12:00", "课程4");

        if (hashMap.containsKey("9:00")) {
            System.out.println("该老师在该时间段内已经有课程安排");
        }


    }

}
