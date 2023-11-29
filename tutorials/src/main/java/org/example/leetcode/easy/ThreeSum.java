package org.example.leetcode.easy;

import org.example.helpercode.Pair;

import java.util.*;

public class ThreeSum {

    public static List<Pair<Integer, Integer>> twoSum(List<Integer> nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Pair<Integer, Integer>> list = new ArrayList<>();

        for (Integer num: nums) {
            Integer x = map.get(target - num);
            if (x == null) {
                map.put(num, num);
            } else {
                map.remove(target - num);
                if (num < target-num) {
                    Pair<Integer, Integer> pair = new Pair<>(num, target - num);
                    list.add(pair);
                } else {
                    Pair<Integer, Integer> pair = new Pair<>( target - num, num);
                    list.add(pair);
                }
            }
        }
        return list;
    }

    public static String getKey(int number, int key, int value) {
        if (number < key) {
            return String.valueOf(number) + String.valueOf(key) + String.valueOf(value);
        } else if (number > value) {
            return String.valueOf(key) + String.valueOf(value) + String.valueOf(number);
        } else {
            return String.valueOf(key) + String.valueOf(number) + String.valueOf(value);
        }
    }

    public static void calculate(List list, int number, int target, List<List<Integer>> result, Set<String> resultSet) {

        List<Pair<Integer, Integer>> pairList = twoSum(list, target-number);
        for (Pair<Integer, Integer>pair: pairList) {

            String key = getKey(number, pair.getKey(), pair.getValue());
            if (resultSet.add(key)) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(number);
                triplet.add(pair.getKey());
                triplet.add(pair.getValue());
                result.add(triplet);
            }
        }

    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<Integer> list = new LinkedList<>();
        for (int i: nums) {
            list.add(i);
        }

        List<List<Integer>> result = new ArrayList<>();
        int target = 0;


        Set<String> resultSet = new HashSet<>();


        ListIterator<Integer> listIterator = list.listIterator();
        while(listIterator.hasNext()) {
            Integer i = listIterator.next();
            listIterator.remove();
            calculate(list, i, target, result, resultSet);
            listIterator.add(i);
        }

        for (List<Integer> l: result) {
            list.stream().forEach(i -> System.out.print(" " + i));
            System.out.println();
        }
    }
}
