package com.company;

public class _25ReverseNodesinkGroup
{
    public static void main(String args[]){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        int k=2;
        _25Solution sol=new _25Solution();
        ListNode res=sol.reverseKGroup(head,k);
        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);
    }
}

class _25Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode h=new ListNode();
        h.next=null;
        int i=0;
        int j=1;
        ListNode p=head;
        ListNode q=p.next;
        while(q!=null){
            if(j==k){
                head.next=q;
            }
            if(j-i==k){
                ListNode tmp;
                while(i!=j) {
                    tmp=p.next;
                    p.next = q;
                    q = p;
                    p = tmp;
                    i+=1;
                }
            }
            q=q.next;
            j+=1;
        }
        return h.next;
    }
}
