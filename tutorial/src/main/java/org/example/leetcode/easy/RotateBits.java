package org.example.leetcode.easy;

public class RotateBits {

    public static int reverseBits(int n) {
        int result = 0;
        while ( n > 0) {
            int bit = n & 1;
            n = n>>1;
            int x =  (int)((int)(result << 1) & bit);
            result = x;
            System.out.println(bit + " " + n + " " + result);
        }
        return result;
    }

    public static void main() {
        RotateBits rotateBits = new RotateBits();
        reverseBits(10);
    }
}
