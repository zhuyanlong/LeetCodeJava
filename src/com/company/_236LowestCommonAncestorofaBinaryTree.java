package com.company;

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
        TreeNode res=lowestCommonAncestor(root,p,q);
        System.out.println(res.val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
//        找到了p结点或q结点
        if(root==p || root==q){
            return root;
        }
//        分别在左右子树寻找
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

//        如果p和q都找到了，那么此时的root就是最近公共祖先
        if(left!=null && right!=null){
            return root;
//            如果右节点为null
        }else if(left!=null){
            return left;
        }else if(right!=null){
            return right;
        }else{
            return null;
        }
    }
}
