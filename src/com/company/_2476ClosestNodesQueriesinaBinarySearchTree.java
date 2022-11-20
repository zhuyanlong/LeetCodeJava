package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _2476ClosestNodesQueriesinaBinarySearchTree {
    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        for (Integer query : queries) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(-1);
            tmp.add(-1);
            res.add(tmp);
        }
        List<Integer> inOrderArray = inOrder(root);
        for (int i = 0; i < queries.size(); i++) {

        }
        return res;
    }

    // 迭代中序遍历，要记住这种写法，关键在于理解这种写法，因为每次中序遍历都会用到的
    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()) {
            while (tmp != null) {
                stack.add(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            res.add(tmp.val);
            tmp = tmp.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(14);
//        TreeNode root = new TreeNode(4);
//        root.right = new TreeNode(9);
        List<Integer> queries = new ArrayList<>();
        queries.add(2);
        queries.add(5);
        queries.add(16);
//        queries.add(3);
        List<List<Integer>> res = closestNodes(root, queries);
    }
}
