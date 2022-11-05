package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class _236LowestCommonAncestorofaBinaryTree {
    public static void main(String args[]){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(5);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);
        TreeNode p=root.left;
        TreeNode q=root.right;
        TreeNode res = lowestCommonAncestor(root,p,q);
        System.out.println(res.val);
    }
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> leftPath = findPath(root, p);
        Stack<TreeNode> rightPath = findPath(root, q);
        int index = Math.min(leftPath.size(), rightPath.size()) - 1;
        TreeNode res = root;
        while (index != 0) {
            if (leftPath.elementAt(index) == rightPath.elementAt(index)) {
                return leftPath.elementAt(index);
            }
            index--;
        }
        return res;
    }

    private static class Node{
        TreeNode node;
        int level;
        Node(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
        int getLevel() {
            return this.level;
        }
        TreeNode getNode() {
            return this.node;
        }
    }

    private static Stack<TreeNode> findPath(TreeNode root, TreeNode target){
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root, 1));
        Stack<TreeNode> path = new Stack<>();
        path.add(root);
        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            while (path.size() >= tmp.getLevel()) {
                path.pop();
            }
            path.add(tmp.getNode());
            if (tmp.getNode() == target) {
                break;
            }
            if (tmp.getNode().left != null) {
                Node leftNode = new Node(tmp.getNode().left, tmp.getLevel()+1);
                stack.push(leftNode);
            }
            if (tmp.getNode().right != null) {
                Node rightNode = new Node(tmp.getNode().right, tmp.getLevel()+1);
                stack.push(rightNode);
            }
        }
        return path;
    }

        public static TreeNode recursionLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        // 找到了p结点或q结点
        if(root==p || root==q){
            return root;
        }
        // 分别在左右子树寻找
        TreeNode left=recursionLowestCommonAncestor(root.left,p,q);
        TreeNode right=recursionLowestCommonAncestor(root.right,p,q);

        // 如果p和q都找到了，那么此时的root就是最近公共祖先
        if(left!=null && right!=null){
            return root;
        // 如果右节点为null
        }else if(left!=null){
            return left;
        }else if(right!=null){
            return right;
        }else{
            return null;
        }
    }
}
