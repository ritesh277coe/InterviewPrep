package org.example.leetcode.easy;

import java.util.*;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> indices = new ArrayList<>();

        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                indices.add(index);
                indices.add(i);
            }
            map.put(nums[i], i);
        }

        int[] result = new int[indices.size()];
        for(int index: indices) {
           result[x] = index;
           x++;
        }

        return result;
    }

//
//    public static int reverseBits(int n) {
//        int result = 0;
//        while ( n > 0) {
//            int bit = n & 1;
//            n = n>>1;
//             result =  (int)((int)(result << 1) | bit);
//
//            System.out.println(bit + " " + n + " " + result);
//        }
//        return result;
//    }

    public static void main(String[] args) {

        Deque<Integer>dq;
        //Integer.valueOf
//            int[] nums = {10, 20};
//            int k;
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int i: nums) {
//                Integer x = map.get(Integer.valueOf(i));
//
//                if (x == null) {
//                    map.put(Integer.valueOf(i), 1);
//                } else {
//                    //Integer y = new Integer(x.intValue()+1);
//                    map.put(Integer.valueOf(i), x.intValue()+1);
//                }
//            }
//
//            //Creating priority Queue
//            Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> {return Integer.compare(a.getValue(), b.getValue());});
//            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
//            while (it.hasNext()) {
//                 //if (q.size() == k) {
//                     //q.pop();
//                 }
//                Map.Entry<Integer, Integer> kv = it.next();
//                q.add(kv);
//            }
//
//            //q.stream().forEach((e) -> {System.out.println(e.getKey() + ":" + e.getValue());});
//
//        }

        //reverseBits(32);
        TwoSum twoSum = new TwoSum();
        int[] arr = new int[]{3,2,4};
        int[] indices = twoSum.twoSum(arr, 6);

        //System.out.println(indices);
    }
}
