package com.leetcode.exer;

/**
 * @author lixhui
 * @create 2021-10-23:37
 *
 *
 * 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Solution4 {
    public String longestCommonPrefix(String[] strs) {
        int count = strs.length;

        if (strs == null || count < 1) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < count; i++) {
            prefix = Prefix(prefix,strs[i]);
        }

        return prefix;
    }

    private String Prefix(String s1,String s2){
        int minLen = (s1.length() > s2.length() ? s2.length() : s1.length());
        int count = 0;

        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) == s2.charAt(i)){
                count++;
            }else{
                break;
            }
        }
        return s1.substring(0,count);
    }
}
