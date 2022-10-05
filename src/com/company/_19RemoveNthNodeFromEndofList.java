package com.company;

import com.company.ListNode;

public class _19RemoveNthNodeFromEndofList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode fast = h;
        ListNode slow = h;
        while(n > 0) {
            fast = fast.next;
            n--;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next=slow.next.next;
        return h.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        head = removeNthFromEnd(head, 2);
        while(head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
