package com.atguigu.exer;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lixhui
 * @create 2021-10-16:48
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        //方式一：暴力解法
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }

        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum1(int[] nums, int target) {
        //方式二：使用hashMap集合
        int length = nums.length;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(nums[0],0);

        for (int i = 1; i < length; i++) {
            int antherSum = target - nums[i];
            if (hashMap.containsKey(antherSum)){
                return new int[]{hashMap.get(antherSum),i};
            }
            hashMap.put(nums[i],i);

        }

        throw new IllegalArgumentException("No two sum solution");


    }
}