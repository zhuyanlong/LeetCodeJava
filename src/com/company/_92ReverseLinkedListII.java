package com.company;

public class _92ReverseLinkedListII {
    public static void main(String args[]){

    }
    private  ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode h=null;
        if(head==null){
            return null;
        }
        ListNode p=head;
        while(p.next!=null && p.next.val!=left){
            p=p.next;
        }
        ListNode t=p.next;
        ListNode q=head;
        while(q!=null && q.val!=right){
            q=q.next;
        }
        ListNode succ=q.next;
        return h.next;
    }
    private ListNode reverseLinkList(ListNode head){

        return null;
    }
}
