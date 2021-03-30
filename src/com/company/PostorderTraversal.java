package com.company;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        List<Integer> res=new ArrayList<Integer>();
        recursion(root,res);
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
}
