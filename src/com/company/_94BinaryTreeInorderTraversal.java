package com.company;

import java.util.*;

public class _94BinaryTreeInorderTraversal {
    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        _94Solution sol=new _94Solution();
        sol.inorderTraversal(root);
    }
}

class _94Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        stacktraversal(root,res);
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

//    模拟遍历过程，对于已经遍历过的节点，则不再遍历，避免循环
    public void stacktraversal(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        Set<TreeNode> visited=new HashSet<>();
        while(!stack.isEmpty()){
            TreeNode p=stack.peek();
            while(p.left!=null && !visited.contains(p.left)){
                stack.add(p.left);
                p=p.left;
            }
            TreeNode tmp=stack.pop();
            visited.add(tmp);
            res.add(tmp.val);
            if(tmp.right!=null){
                stack.add(tmp.right);
            }
        }
    }
}
