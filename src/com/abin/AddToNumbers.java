package com.abin;

import java.util.LinkedList;

public class AddToNumbers {

    public static void main(String[] args) {
        int v1= addTwoNum(new ListNode(2), new ListNode(5)).val;
        int v2 = addTwoNum(new ListNode(4), new ListNode(6)).val;
        int v3 = addTwoNum(new ListNode(3), new ListNode(4)).val;
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
    }

    public static ListNode addTwoNum(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val: 0;
            int y = (q != null) ? q.val:0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry  > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
