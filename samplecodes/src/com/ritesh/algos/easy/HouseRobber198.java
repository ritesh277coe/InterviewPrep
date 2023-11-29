package com.ritesh.algos.easy;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber198 {

    public int robHouses(int[] nums) {
        int maxIndex = nums.length - 1;
        Map<Integer, Integer> map = new HashMap<>();

        if(maxIndex ==  0) {
            return nums[0];
        } else if(maxIndex == 1) {
            return max(nums[0], nums[1]);
        }

        while (maxIndex >= 0) {
            int val = rob(maxIndex, nums, map);
            System.out.println("Rob"+maxIndex + "=" + val);
            maxIndex--;
        }

        return max(rob(0, nums, map), rob(1, nums, map));
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int rob(int index, int[] nums, Map<Integer, Integer> map) {
        Integer val = map.get(index);
        if (val != null)
            return val.intValue();

        if (index == nums.length - 1) {
            return nums[index];
        } else if (index == nums.length - 2) {
            return max (nums[index+1], nums[index]);
        }

        int value = max(rob(index + 2, nums, map) + nums[index],
                rob(index + 1, nums, map));

        map.put(index, value);
        return value;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,1,1,2};
        HouseRobber198 houseRobber198 = new HouseRobber198();
        System.out.println(houseRobber198.robHouses(nums));
    }
}
