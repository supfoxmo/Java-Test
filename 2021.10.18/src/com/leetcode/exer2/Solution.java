package com.leetcode.exer2;

/**
 * @author lixhui
 * @create 2021-10-21:14
 * <p>
 * <p>
 * 26. 删除有序数组中的重复项
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        if (nums == null || len == 0)
            return 0;

        int temp = nums[0];

        for (int i = 1; i < len; ) {
            if (temp == nums[i]) {
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                len--;
            } else {
                temp = nums[i];
                i++;
            }
        }

        return len;
    }

    //升级版
    public int removeDuplicates1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}


