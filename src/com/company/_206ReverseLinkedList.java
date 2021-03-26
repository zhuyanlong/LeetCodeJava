package com.company;

public class _206ReverseLinkedList {
    public static void main(String args[]){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        Solution s=new Solution();
        s.reverseList(head);
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode h=new ListNode();
//        这个地方赋值为null是因为
        h.next=null;
        ListNode p=head;
        ListNode q=head.next;
        while(q!=null){
            p.next=h.next;
            h.next=p;
            p=q;
            q=q.next;
        }
        p.next=h.next;
        h.next=p;
//        System.out.println(h.next.val);
//        System.out.println(h.next.next.val);
//        System.out.println(h.next.next.next.val);
//        System.out.println(h.next.next.next.next.val);
//        System.out.println(h.next.next.next.next.next.val);
        return h.next;
    }
}