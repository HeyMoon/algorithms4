package com.dyh.algorithms4.leetcode;

/**
 * @author: dengyunhui
 * @datetime: 2022/2/18 下午5:48
 * @description:
 */
public class AddBinaryString {

    public static void main(String[] args) {
        AddBinaryString addBinaryString = new AddBinaryString();
        System.out.println(addBinaryString.addBinary("11", "10"));
        System.out.println(addBinaryString.addBinary("11010", "1011"));
    }

    public String addBinary(String a, String b) {
        int n = a.length() - 1;
        int m = b.length() - 1;
        int carry = 0;

        StringBuffer stringBuffer = new StringBuffer();
        while (n >= 0 || m >= 0 || carry != 0) {
            int ii = n >= 0 ? a.charAt(n--) - '0' : 0;
            int jj = m >= 0 ? b.charAt(m--) - '0' : 0;
            carry = ii + jj + carry;
            stringBuffer.append(carry % 2);
            carry /= 2;
        }

        return stringBuffer.reverse().toString();
    }

}
