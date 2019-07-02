package com.glodon.bim5d.leetcode;

/**
 * @author: guanl-c
 * @date: 2019/7/1 15:06
 * @description:
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = addTwoNumbers.new ListNode(5);
//        l1.next = addTwoNumbers.new ListNode(8);
//        l1.next.next = addTwoNumbers.new ListNode(3);
        ListNode l2 = addTwoNumbers.new ListNode(5);
//        l2.next = addTwoNumbers.new ListNode(6);
//        l2.next.next = addTwoNumbers.new ListNode(4);
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println("****");
    }

    // 过于繁琐
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode result = new ListNode(0);
        ListNode r = result;
        int highData = 0;
        int lowData = 0;
        while (p != null || q != null || highData != 0) {
            if (p != null && q != null) {
                lowData = (p.val + q.val + highData) % 10;
                highData = (p.val + q.val + highData) / 10;
                ListNode temp = new ListNode(lowData);
                p = p.next;
                q = q.next;
                r.next = temp;
                r = r.next;
            } else if (p == null && q != null) {
                lowData = (q.val + highData) % 10;
                highData = (q.val + highData) / 10;
                ListNode temp = new ListNode(lowData);
                q = q.next;
                r.next = temp;
                r = r.next;
            } else if ( p != null) {
                lowData = (p.val + highData) % 10;
                highData = (p.val + highData) / 10;
                ListNode temp = new ListNode(lowData);
                p = p.next;
                r.next = temp;
                r = r.next;
            } else {
                ListNode temp = new ListNode(highData);
                highData = 0;
                r.next = temp;
                r = r.next;
            }
        }
        if (result.next != null) {
            result = result.next;
            return result;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode result = new ListNode(0);
        ListNode r = result;
        int highData = 0;
        while (p != null || q != null) {
            int i = (p == null) ? 0 : p.val;
            int j = (q == null) ? 0 : q.val;
            int sum = i + j + highData;
            highData = (sum) / 10;
            r.next = new ListNode((sum) % 10);
            if (p != null) p = p.next;
            if (q != null) q = q.next;
            r = r.next;
        }
        if (highData != 0) {
            ListNode temp = new ListNode(highData);
            r.next = temp;
        }
        return result.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
