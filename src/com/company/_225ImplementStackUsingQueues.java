package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class _225ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        int res = myStack.top();
        res = myStack.pop();
        boolean b = myStack.empty();
    }
}

class MyStack {
    Queue<Integer> first;
    Queue<Integer> second;

    public MyStack() {
        this.first = new LinkedList<>();
        this.second = new LinkedList<>();
    }

    public void push(int x) {
        first.add(x);
    }

    public int pop() {
        while (first.size() > 1) {
            second.add(first.remove());
        }
        int res = first.remove();
        while (!second.isEmpty()) {
            first.add(second.remove());
        }
        return res;
    }

    public int top() {
        while (first.size() > 1) {
            second.add(first.remove());
        }
        int res = first.peek();
        second.add(first.remove());
        while (!second.isEmpty()) {
            first.add(second.remove());
        }
        return res;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}