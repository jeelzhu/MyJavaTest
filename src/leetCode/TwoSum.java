package leetCode;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    public static void main(String[] args) {
        int[] arr = {3,3,3};


        Map<Integer, Integer> map = new HashMap<>();
        Integer test = map.get(5);
        for (int i=0; i< arr.length ;i++){
            map.put(arr[i], i);
        }

        int[] result = new TwoSum().twoSum(arr, 6);
        System.out.println();
    }
}
