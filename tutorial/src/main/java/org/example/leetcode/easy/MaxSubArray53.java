package org.example.leetcode.easy;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaxSubArray53 {
    public int max(int a, int b) {
        return (a>b)?a:b;
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int runningSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            runningSum = max(runningSum+nums[i], nums[i]);
            maxSum = max(runningSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] arr) {
        MaxSubArray53 maxSubArray53 = new MaxSubArray53();
        int[] input = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray53.maxSubArray(input));
    }
}
