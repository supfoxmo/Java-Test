package com.leetcode.exer;

/**
 * @author lixhui
 * @create 2021-10-21:18
 *
 *
 * 7. 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class Solution1 {
    public int reverse(int x) {
        int result = 0;
        int count = 0;
        int temp = 0;
        while (x != 0){
            temp = x % 10;
            if (count == 9){
                //判断是否 大于 最大32位整数
                if (result>214748364 || (result==214748364 && temp>7)) {
                    return 0;
                }
                //判断是否 小于 最小32位整数
                if (result<-214748364 || (result==-214748364 && temp<-8)) {
                    return 0;
                }
            }
            result = result * 10 + temp;
            count++;
            x /= 10;
        }
        return result;
    }
}
