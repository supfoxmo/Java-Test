package com.leetcode.exer1;

/**
 * @author lixhui
 * @create 2021-10-20:26
 */
public class SolutionTest {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        Solution solution = new Solution();

        ListNode listNode = solution.mergeTwoLists(l1, l2);

        while (listNode != null){
            System.out.println(listNode.val);

            listNode = listNode.next;
        }
    }
}
