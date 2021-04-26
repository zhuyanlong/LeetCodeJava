package com.company;

//已知有一个链表，以及x，重排链表内容，将所有小于x的结点都放到大于等于x的节点之前，且相对位置不能发生变化
public class xiaomi202104 {
    public static void main(String args[]){
        ListNode head=new ListNode(1);
        head.next=new ListNode(4);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(2);
        ListNode res=reset(head,3);
        printList(res);
    }
    public static ListNode reset(ListNode head,int x){
        if(head==null){
            return head;
        }
        ListNode h=new ListNode();
        h.next=head;
        ListNode p=head;
        ListNode q=h;
        ListNode big=new ListNode();
        ListNode tmp=big;
        tmp.next=big;
        while(p!=null){
            if(p.val>=x){
                q.next=p.next;
                tmp.next=p;
                p=p.next;
                tmp=tmp.next;
                tmp.next=null;
            }else{
                p=p.next;
                q=q.next;
            }
        }
        q.next=big.next;
        return h.next;
    }
    public static void printList(ListNode head){
        ListNode tmp=head;
        while(tmp!=null){
            System.out.print(tmp.val+" ");
            tmp=tmp.next;
        }
    }
}
