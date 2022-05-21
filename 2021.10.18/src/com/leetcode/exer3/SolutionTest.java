package com.leetcode.exer3;

/**
 * @author lixhui
 * @create 2021-10-21:58
 */
public class SolutionTest {
    public static void main(String[] args) {
        int[] nums = {2,3,5,4,8,1,9,0,2,3,0,6,3,7,7,7,3,6,5,4};

        Solution solution = new Solution();

        int len = solution.removeElement(nums, 3);

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);

        }
    }

}
