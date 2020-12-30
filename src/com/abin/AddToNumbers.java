package com.abin;

import java.util.LinkedList;

public class AddToNumbers {

    public static void main(String[] args) {
        ListNode n1= addTwoNum(new ListNode(2), new ListNode(5), null);
        ListNode n2 = addTwoNum(new ListNode(4), new ListNode(6), n1.next);
        ListNode n3 = addTwoNum(new ListNode(3), new ListNode(4), n2.next);
        System.out.println(n1.val);
        System.out.println(n2.val);
        System.out.println(n3.val);

    }

    public static ListNode addTwoNum(ListNode l1, ListNode l2, ListNode carryNode) {
        ListNode dummyHead = new ListNode(0);
        int carry =0;
        if (carryNode != null) {
            carry = carryNode.val;
        }
        ListNode p = l1, q = l2, curr = dummyHead;
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
