package com.company;

import java.util.ArrayList;
import java.util.List;

public class _94BinaryTreeInorderTraversal {
    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        _94Solution sol=new _94Solution();
        sol.inorderTraversal(root);
    }
}

//使用栈的方式做中序遍历
//class _94Solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res=new ArrayList<Integer>();
//        List<TreeNode> stack=new ArrayList<TreeNode>();
//        stack.add(root);
//        while(stack.size()!=0){
//            TreeNode tmp=stack.get(stack.size()-1);
//            stack.remove(stack.size()-1);
//            if(tmp.left!=null){
//                stack.add(tmp.left);
//            }
//            if(tmp.right!=null){
//                stack.add(tmp.right);
//            }
//
//        }
//        for(int i=0;i<res.size();i++){
//            System.out.print(res.get(i)+" ");
//        }
//        return res;
//    }
//}

class _94Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        traversal(root,res);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
        return res;
    }

    public void traversal(TreeNode root,List<Integer> res){
        if(root==null){
            return ;
        }
        if(root.left!=null){
            traversal(root.left,res);
        }
        res.add(root.val);
        if(root.right!=null){
            traversal(root.right,res);
        }
    }
}
