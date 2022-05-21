package com.leetcode.exer;

/**
 * @author lixhui
 * @create 2021-10-23:37
 */
public class SolutionTest4 {
    public static void main(String[] args) {

        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"Leet", "Leetcode", "Leed"};
        String[] strs3 = {"filet", "conpute", "paike"};

        Solution4 solution4 = new Solution4();

        String prefix = solution4.longestCommonPrefix(strs1);
        System.out.println(prefix.toString() + "\n");
        String prefix1 = solution4.longestCommonPrefix(strs2);
        System.out.println(prefix1.toString() + "\n");
        String prefix2 = solution4.longestCommonPrefix(strs3);
        System.out.println(prefix2.toString() + "\n");
    }


}
