package org.example.leetcode.easy;

import java.util.Arrays;

public class MergeSortedArray88 {

    //Start sorting from the end of array so that only max is copied
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int f = m-1;
        int s = n-1;
        int e = m+n-1;

        while (f > -1 && s > -1) {
            if (nums1[f] > nums2[s]) {
                nums1[e] = nums1[f];
                f--;
            } else {
                nums1[e] = nums2[s];
                s--;
            }
            e--;
        }

        while (s > -1) {
            nums1[e] = nums2[s];
            e--;
            s--;
        }
    }

    public static void main(String[] input) {
        MergeSortedArray88 mergeSortedArray88 = new MergeSortedArray88();
        int[] arr1 = new int[] {2,5,6, 0, 0, 0};
        int[] arr2 = new int[] {1,2,3};
        mergeSortedArray88.merge(arr1, 3, arr2, 3);
        Arrays.stream(arr1).forEach(x -> System.out.println(x));
    }
}
