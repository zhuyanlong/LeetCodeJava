package com.company;

public class _705DesignHashSet {
    public static void main(String args[]){
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }
}

class MyHashSet {
    Node head=null;

    public MyHashSet() {
        head=new Node(0);
    }

    public void add(int key) {
        Node h=this.head;
        int flag=0;
        while(h.next!=null){
            if(h.next.data==key){
                flag=1;
                break;
            }
            h=h.next;
        }
        if(flag==0){
            h.next=new Node(key);
        }
    }

    public void remove(int key) {
        Node h=this.head;
        while(h.next!=null){
            if(h.next.data==key){
                h.next=h.next.next;
                break;
            }
            h=h.next;
        }
    }

    public boolean contains(int key) {
        Node h=this.head;
        while(h.next!=null){
            if(h.next.data==key){
                return true;
            }
            h=h.next;
        }
        return false;
    }
}

class Node{
    int data;
    Node next=null;

    public Node(int data){
        this.data=data;
    }
}
