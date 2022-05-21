package com.leetcode.exer;

import java.util.ArrayList;

/**
 * @author lixhui
 * @create 2021-10-22:39
 *
 *
 * 9. 回文数
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 */
public class Solution2 {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (x != 0){
            list.add(x % 10);
            x /= 10;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != list.get(list.size() - 1 - i))
                return false;
        }
        return true;

        //升级版：
//        // 特殊情况：
//        // 如上所述，当 x < 0 时，x 不是回文数。
//        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
//        // 则其第一位数字也应该是 0
//        // 只有 0 满足这一属性
//        if (x < 0 || (x % 10 == 0 && x != 0)) {
//            return false;
//        }
//
//        int revertedNumber = 0;
//        while (x > revertedNumber) {
//            revertedNumber = revertedNumber * 10 + x % 10;
//            x /= 10;
//        }
//
//        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
//        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
//        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
//        return x == revertedNumber || x == revertedNumber / 10;
//
//        作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
