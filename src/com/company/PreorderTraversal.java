package com.company;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public static void main(String args[]){
        List<Integer> res=new ArrayList<>();
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        stacktraversal(root,res);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }
    public static void recursion(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        res.add(root.val);
        if(root.left!=null){
            recursion(root.left,res);
        }
        if(root.right!=null){
            recursion(root.right,res);
        }
    }

    public static void stacktraversal(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp=stack.pop();
            res.add(tmp.val);
            if(tmp.right!=null){
                stack.push(tmp.right);
            }
            if(tmp.left!=null){
                stack.push(tmp.left);
            }
        }
    }
}
