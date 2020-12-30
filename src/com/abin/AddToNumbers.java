package com.abin;

import java.util.LinkedList;

public class AddToNumbers {

    public static void main(String[] args) {
        ListNode n1= addTwoNum(new ListNode(2), new ListNode(9), null);
        ListNode n2 = addTwoNum(new ListNode(1), new ListNode(5), n1.next);
        ListNode n3 = addTwoNum(new ListNode(7), new ListNode(3), n2.next);
        ListNode n4 = addTwoNum(new ListNode(6), new ListNode(6), n3.next);
        ListNode n5 = addTwoNum(new ListNode(5), null, n4.next);
        System.out.println(n1.val);
        System.out.println(n2.val);
        System.out.println(n3.val);
        System.out.println(n4.val);
        System.out.println(n5.val);
    }

    public static ListNode addTwoNum(ListNode l1, ListNode l2, ListNode carryNode) {
        ListNode dummyHead = new ListNode(0);
        int carry =0;
        if (carryNode != null) {
            carry = carryNode.val;
        }
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val: 0;
            int y = (l2 != null) ? l2.val:0;
            int sum = carry + x + y;
            carry = sum / 10;
            dummyHead.next = new ListNode(sum % 10);
            dummyHead = dummyHead.next;
            if(l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry  > 0) {
            dummyHead.next = new ListNode(carry);
        }
        return dummyHead;
    }

    public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
