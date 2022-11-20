package com.company;

import java.util.*;

public class _2471MinimumNumberofOperationstoSortaBinaryTreebyLevel {
    public static int minimumOperations(TreeNode root) {
        Stack<StackVal> stack = new Stack<>();
        stack.add(new StackVal(root, 0));
        List<List<Integer>> lst = new ArrayList<>();
        while (!stack.isEmpty()) {
            StackVal tmp = stack.pop();
            if (lst.size() <= tmp.level) {
                List<Integer> tmpList = new ArrayList<>();
                lst.add(tmpList);
            }
            lst.get(tmp.level).add(tmp.root.val);
            if (tmp.root.right != null) {
                stack.add(new StackVal(tmp.root.right, tmp.level + 1));
            }
            if (tmp.root.left != null) {
                stack.add(new StackVal(tmp.root.left, tmp.level + 1));
            }
        }
        int count = 0;
        for (List<Integer> array : lst) {
            count += f(array);
        }
        return count;
    }

    //  交换排序,实在想不出好的解法
    //  可以直接使用交换结论,在网上查
    public static int f(List<Integer> array) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = array.size();
        for (int i = 0; i < n; i++) {
            map.put(array.get(i), i);
        }
        Collections.sort(array);
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || map.get(array.get(i)) == i) {
                continue;
            }
            int j = i;
            int cycle = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = map.get(array.get(j));
                cycle++;
            }
            if (cycle > 0) {
                ans += cycle - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(3);
        root.right = new TreeNode(43);
        root.left.left = new TreeNode(27);
        root.left.right = new TreeNode(29);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(17);
        root.right.right.left = new TreeNode(18);
        root.right.right.right = new TreeNode(10);

        minimumOperations(root);
    }
}

class StackVal {
    TreeNode root;
    int level;
    public StackVal(TreeNode root, int level) {
        this.root = root;
        this.level = level;
    }
}
