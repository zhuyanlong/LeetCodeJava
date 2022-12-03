package com.company;

public class _450DeleteNodeinaBST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
    }
}
