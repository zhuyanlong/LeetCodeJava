package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    // 迭代法 中序遍历
    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()) {
            // 存入所有最左侧节点
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
}
