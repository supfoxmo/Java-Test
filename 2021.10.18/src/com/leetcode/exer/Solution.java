package com.leetcode.exer;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author lixhui
 * @create 2021-10-21:07
 *
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 */
public class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        if (s == null || length == 0 || length % 2 != 0)
            return false;

        int index = 1;
        int[] value = new int[length];
        value[0] = type(s.charAt(0));

        for (int i = 1; i < length; i++) {
            int temp = type(s.charAt(i));
            if (index > 0 && temp > value[index -1] && temp + value[index - 1] == 7){
                index--;
            }else{
                value[index] = temp;
                index++;
            }
        }
        if (index == 0)
            return true;
        return false;
    }

    //升级版
    public boolean superisValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }


    private int type(char c){
        switch (c){
            case '(':
                return 1;
            case '[':
                return 2;
            case '{':
                return 3;
            case '}':
                return 4;
            case ']':
                return 5;
            case ')':
                return 6;
        }
        throw new IllegalArgumentException("字符类型不符合要求");
    }
}
