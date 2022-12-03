package com.company;

public class _141LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode h = new ListNode();
        h.next = head;
        ListNode slow = h;
        ListNode fast = h;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(-4);
//        head.next.next.next.next = head.next;
//        head.next.next = head;
        boolean res = hasCycle(head);
    }
}
