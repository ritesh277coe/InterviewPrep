package org.example.leetcode.easy;

import java.util.Deque;
import java.util.Stack;

public class AddTwoNumbers {


    public static int getBinarySum(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0) {
            return 0;
        } else if (a == 0 && b == 0 && c == 1) {
            return 1;
        } else if (a == 0 && b == 1 && c == 0) {
            return 1;
        } else if (a == 0 && b == 1 && c == 1) {
            return 2;
        } else if (a == 1 && b == 0 && c == 0) {
            return 1;
        } else if (a == 1 && b == 0 && c == 1) {
            return 2;
        } else if (a == 1 && b == 1 && c == 0) {
            return 2;
        } else if (a == 1 && b == 1 && c == 1) {
            return 3;
        } else {
            return -1;
        }
    }

    //Does not work for -ve numbers
    public static int getSum(int a, int b) {
        System.out.println(a + "=" + Integer.toBinaryString(a));
        System.out.println(b + "=" + Integer.toBinaryString(b));
        int sizeOfInt = 8;
        int carry = 0;
        int result = 0;
        int i;

        for (i = 0; i < sizeOfInt; i++) {
            int a1 = (a & (1 << i)) >> i;
            int b1 = (b & (1 << i)) >> i;
            int c1 = 0;

            System.out.print(" " + a1 + " " + b1 + " " + carry + " ");
            // System.out.println();
            c1 = getBinarySum(a1, b1, carry);
            System.out.print(i + " " + c1);
            if (c1 == 3) {
                c1 = 1;
                carry = 1;
            } else if (c1 == 2) {
                c1 = 0;
                carry = 1;
            } else {
                carry = 0;
            }
            System.out.print(" " + c1 + " " + carry);
            if (c1 > 0) {
                result = result | (1 << i);
            }
            System.out.println("  result " + Integer.toBinaryString(result));
        }

        if (carry > 0) {
            result = result | (1 << i);
        }

        return result;
    }

    public static int getSum1(int a, int b) {

        while (b != 0) {
            int tmp = ((a&b) << 1);
            a = a^b;
            b = tmp;
        }

        return a;
    }


    public static void main(String[] args) {
        char ch = 'a';
        for (int i = 1; i < 32; i++) {
            double c = Math.pow(i, 3)%33;
            System.out.println("Char ch= " + ch + " i= " + i + " c= " + c);
            ch++;
        }
        //Deque<Pair<Integer, Integer>> p;
        Stack<Integer> s;
        System.out.println(AddTwoNumbers.getSum(-30, -40));
        System.out.println(AddTwoNumbers.getSum1(5, -2));

    }
}
