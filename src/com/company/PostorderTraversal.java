package com.company;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        List<Integer> res=new ArrayList<Integer>();
        recursion(root,res);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }

    public static void recursion(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }
        if(root.left!=null){
            recursion(root.left,res);
        }
        if(root.right!=null){
            recursion(root.right,res);
        }
        res.add(root.val);
    }

//    由先序遍历改造成的后序遍历
    public static void reversepreorder(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode tmp=stack.pop();
            res.add(tmp.val);
            if(tmp.left!=null){
                stack.add(tmp.left);
            }
            if(tmp.right!=null){
                stack.add(tmp.right);
            }
        }
        Collections.reverse(res);
    }
}
