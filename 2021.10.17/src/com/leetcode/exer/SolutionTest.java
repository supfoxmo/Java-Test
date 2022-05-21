package com.leetcode.exer;

/**
 * @author lixhui
 * @create 2021-10-20:14
 */
public class SolutionTest {
    public static void main(String[] args) {
        int nums1[] = {3,5,7,9,11};
        int nums2[] = {1,4,8,10};

        Solution solution = new Solution();

        double result = solution.findMedianSortedArrays(nums1, nums2);

        System.out.println(result);
    }

}
