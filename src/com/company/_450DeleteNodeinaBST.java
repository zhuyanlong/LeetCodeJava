package com.company;

import java.util.Stack;

//感觉难度有点超过自己的水平，能写多少就写多少
public class _450DeleteNodeinaBST {
    public static TreeNode myDeleteNode(TreeNode root, int key) {
        if(root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            while (stack.size() > 2) {
                stack.pop();
            }
            TreeNode tmp = stack.peek();
            if (tmp != null) {
                if (tmp.val > key) {
                    stack.add(tmp.left);
                } else if (tmp.val < key) {
                    stack.add(tmp.right);
                } else {
//                    因为是引用所以不能直接采用这种方式修改值
                    if (tmp.left == null && tmp.right == null) {
                        tmp = null;
                    } else if (tmp.left == null) {
                        tmp = tmp.right;
                    } else if (tmp.right == null) {
                        tmp = tmp.left;
                    }
                    break;
                }
            }
        }
        return root;
    }
//    使用递归进行计算
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }else if (root.right == null) {
                return root.left;
            }
            TreeNode next = nextInorderNode(root.right);
            root.val = next.val;
            root.right = deleteNode(root.right, next.val);
        }
        return root;
    }

    public static TreeNode nextInorderNode(TreeNode node) {
        while (node.left != null) {
            node =node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        deleteNode(root, 2);
    }
}
