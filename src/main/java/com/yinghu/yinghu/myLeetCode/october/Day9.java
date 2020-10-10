package com.yinghu.yinghu.myLeetCode.october;

/**
 * @author
 * @describetion ${}
 * @date 2020-10-9
 */
public class Day9 {


   // 141. 环形链表

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

        public boolean hasCycle(ListNode head) {

            //解决循环判断的死循环问题
            //将全部的链表节点的地址存储于一个map中，如果报出异常，则是一个循环链表
            //也可以将这个数值存放在一个set中，看下长度有没有发生变化，
            // 如果没有，则证明这个链表是一个环形链表
            //先判断链表的长度，如果链表的长度为1，则不是环链表
            if(head.next==null){



            }








            return true;


        }

}
