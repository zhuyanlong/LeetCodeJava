package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class _236LowestCommonAncestorofaBinaryTree {
    public static void main(String args[]){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(5);
        root.right=new TreeNode(1);
        TreeNode p=root.left;
        TreeNode q=root.right;
        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);
        _236LowestCommonAncestorofaBinaryTree sol=new _236LowestCommonAncestorofaBinaryTree();
        sol.lowestCommonAncestor(root,p,q);
//        System.out.println(res.val);
    }
//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root==null){
//            return null;
//        }
////        找到了p结点或q结点
//        if(root==p || root==q){
//            return root;
//        }
////        分别在左右子树寻找
//        TreeNode left=lowestCommonAncestor(root.left,p,q);
//        TreeNode right=lowestCommonAncestor(root.right,p,q);
//
////        如果p和q都找到了，那么此时的root就是最近公共祖先
//        if(left!=null && right!=null){
//            return root;
////            如果右节点为null
//        }else if(left!=null){
//            return left;
//        }else if(right!=null){
//            return right;
//        }else{
//            return null;
//        }
//    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return root;
    }

    public Stack<TreeNode> findPath(TreeNode root, TreeNode target){
        Stack<Node> st=new Stack<>();
        st.push(new Node(root,0));
        Stack<TreeNode> stp=new Stack<>();
        while(!st.isEmpty()){
            Node tmp=st.pop();
            if(!stp.isEmpty()){
                while(tmp.level!=stp.size()){
                    stp.pop();
                }
            }
            stp.push(tmp.treeNode);
            if(tmp.treeNode==p){
                break;
            }
            if(tmp.treeNode.left!=null){
                st.push(new Node(tmp.treeNode.left,tmp.level+1));
            }
            if(tmp.treeNode.right!=null){
                st.push(new Node(tmp.treeNode.right,tmp.level+1));
            }
        }
    }

    class Node{
        TreeNode treeNode;
        Integer level;
        Node(TreeNode treeNode,Integer level){
            this.treeNode=treeNode;
            this.level=level;
        }
    }
}
