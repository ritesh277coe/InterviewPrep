package org.example.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class BuySellStock121 {
    public int max(int a, int b) {
        return (a > b)?a:b;
    }

    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int maxProfit = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                maxProfit = max(maxProfit, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r = r+1;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {1,2,3,4,5,6,0,6};
        BuySellStock121 buySellStock121 = new BuySellStock121();
        System.out.println(buySellStock121.maxProfit(prices));

        Set<Integer> set = new HashSet<>();

//        for (i = 0; i < 10; i++) {
//            Integer v = set.add(nums[i]);
//        }
    }
}
