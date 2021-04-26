package com.company;

public class _160IntersectionofTwoLinkedLists {
    public static void main(String args[]){
        ListNode headA=new ListNode(4);
        headA.next=new ListNode(1);
        headA.next.next=new ListNode(8);
        headA.next.next.next=new ListNode(4);
        headA.next.next.next.next=new ListNode(5);
        ListNode headB=new ListNode(5);
        headB.next=new ListNode(6);
        headB.next.next=new ListNode(1);
        headB.next.next.next=headA.next.next;
        ListNode res=getIntersectionNode(headA,headB);
        System.out.println(res.val);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m=0;
        int n=0;
        ListNode tmpA=headA;
        ListNode tmpB=headB;
        while(tmpA!=null){
            m+=1;
            tmpA=tmpA.next;
        }
        while(tmpB!=null){
            n+=1;
            tmpB=tmpB.next;
        }
        if(tmpA!=tmpB){
            return null;
        }
        int length=0;
        if(m>n){
            length=m-n;
            while(length!=0){
                headA=headA.next;
                length-=1;
            }
        }else{
            length=n-m;
            while(length!=0){
                headB=headB.next;
                length-=1;
            }
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
