package leetcode;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println("-----------------");
        int[] nums = {3, 2, 1, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        printArray(result);
    }

    /*
     * {1, 2, 3, 4 }
     * 6
     */
    public static int[] twoSum(int[] nums, int target) {
        printArray(nums);
        Arrays.sort(nums);
        printArray(nums);
        int j = nums.length - 1;
        int i = 0;
        while (j>i){
            int first = nums[i];
            int second = nums[j];
            System.out.println("i: " + i + " j: " + j);
            System.out.println("first: " + first + " second: " + second);
            System.out.println("-----------------");
            if (first + second == target){
                return new int[]{i, j};
            }
            else if (first + second > target){
                j--;
            }
            else{
                i++;
            }
            
        }
        return null;
    }

    private static void printArray(int[] nums){
        for (int i = 0; i < nums.length; i++){
            System.out.print (nums[i]+" ");
        }
        System.out.println();
    }

    
}
