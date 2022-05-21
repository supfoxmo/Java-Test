package com.leetcode.exer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author lixhui
 * @create 2021-10-15:57
 *
 * 4. 寻找两个正序数组的中位数
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 *
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int len = length1 + length2 - 1;

        ArrayList<Integer> list = new ArrayList<>(len);

        for (int i = 0; i < length1; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < length2; i++) {
            list.add(nums2[i]);
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2){
                    return 1;
                }else if (o1 < o2){
                    return -1;
                }else{
                    return 0;
                }
            }
        });

        int len1 = len / 2;
        if (len % 2 != 0){
            return  (list.get(len1) + list.get(len1 + 1))/2.0;
        }

        return  (double)list.get(len1);

    }
}
