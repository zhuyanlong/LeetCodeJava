package com.company;

public class _21MergeTwoSortedLists {
    public static void main(String args[]){
        ListNode l1=new ListNode();
//        l1.next=new ListNode(2);;
//        l1.next.next=new ListNode(4);
        ListNode l2=new ListNode();
//        l2.next=new ListNode(3);
//        l2.next.next=new ListNode(4);
        ListNode h=mergeTwoLists(l1,l2);
        while(h.next!=null){
            System.out.println(h.val);h=h.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head=new ListNode();
        ListNode tmp=head;
        ListNode i=l1;
        ListNode j=l2;
        while(i!=null && j!=null){
            if(i.val<j.val){
                tmp.next=i;
                i=i.next;
            }else{
                tmp.next=j;
                j=j.next;
            }
            tmp=tmp.next;
            tmp.next=null;
        }
        if(i==null){
            tmp.next=j;
        }
        if(j==null){
            tmp.next=i;
        }
        return head.next;
    }
}
