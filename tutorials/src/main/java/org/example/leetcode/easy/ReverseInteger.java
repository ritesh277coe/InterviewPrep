package org.example.leetcode.easy;

import java.util.Random;

public class ReverseInteger {
    public int reverse(int x) {
        int num = x;
        int revNum = 0;

        int MAX_BY_10 = 0x7fffffff/10;
        int MAX_BY_10_R = 0x7fffffff%10;

        if (x < 0) num = num * -1;

        while (num > 0) {
            int q = num/10;
            int r = num%10;
            num = q;

            if (revNum > MAX_BY_10)
                return 0;
            if (revNum == MAX_BY_10 && r > MAX_BY_10_R)
                return 0;

            revNum = revNum*10+r;
        }

        if (x < 0) revNum = revNum*-1;

        return revNum;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println("Reverse " +  "153423 to " +  reverseInteger.reverse(153423));
        System.out.println("Reverse " +  "1534236469 to " +  reverseInteger.reverse(1534236469));

    }
}
