package com.leetcode.exer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lixhui
 * @create 2021-10-21:07
 */
public class SolutionTest {
    public static void main(String[] args) {

        String s1 = "()[]{})(";
        String s2 = "([])[{}]{}";

        Solution solution = new Solution();

        boolean result1 = solution.isValid(s1);

        System.out.println(result1);

        boolean result2 = solution.isValid(s2);
        System.out.println(result2);

        Deque<Character> stack = new LinkedList<Character>();


    }
}
