package com.leetcode.exer2;

/**
 * @author lixhui
 * @create 2021-10-21:14
 */
public class SolutionTest {
    public static void main(String[] args) {
        int[] nums1 = {0,0,1,1,1,2,2,3,3,4};
        int[] nums2 = {5,3,45,6,3,7,654,3,2};

        Solution solution = new Solution();

        int len1 = solution.removeDuplicates(nums1);
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i] + " ");
        }

        System.out.println("\n*************************************");

        int len2 = solution.removeDuplicates(nums2);
        for (int i = 0; i < len2; i++) {
            System.out.print(nums2[i] + " ");
        }
    }
}
