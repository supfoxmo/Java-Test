package com.leetcode.exer3;

/**
 * @author lixhui
 * @create 2021-10-21:57
 *
 *
 * 27. 移除元素
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0)
            return 0;

        for (int i = 0; i < len; ) {
            if (nums[i] == val){
                nums[i] = nums[--len];
            }else{
                i++;
            }
        }
        return len;
    }

    public int removeElement1(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

   
}
