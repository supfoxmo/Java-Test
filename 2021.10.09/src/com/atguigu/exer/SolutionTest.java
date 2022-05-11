package com.atguigu.exer;

/**
 * @author lixhui
 * @create 2021-10-15:29
 */
public class SolutionTest {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

        }

        System.out.println("**************************");

        int[] nums1 = {3, 2, 4, 7, 1};
        int target1 = 6;

        int[] result1 = solution.twoSum1(nums1, target1);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result1[i]);

        }
    }
}
