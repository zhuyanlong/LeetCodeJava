package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//用栈遍历
public class _103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String args[]){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        zigzagLevelOrder(root);
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<Tuple> stack=new Stack<>();
        stack.push(new Tuple(root,1));
        int flag=0;
        while(!stack.isEmpty()){
            Tuple tmp=stack.pop();
            if(res.size()<tmp.getLevel()){
                List<Integer> currentLevel=new ArrayList<>();
                currentLevel.add(tmp.getNode().val);
                res.add(currentLevel);
            }else{
                if(tmp.getLevel()%2==0){
                    res.get(tmp.getLevel()-1).add(tmp.getNode().val);
                }else{
                    res.get(tmp.getLevel()-1).add(0,tmp.getNode().val);
                }

            }
            if(tmp.getNode().left!=null){
                stack.push(new Tuple(tmp.getNode().left,tmp.getLevel()+1));
            }
            if(tmp.getNode().right!=null){
                stack.push(new Tuple(tmp.getNode().right,tmp.getLevel()+1));
            }
        }
        Print(res);
        return res;
    }

    public static void Print(List<List<Integer>> res){
        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
class Tuple{
    TreeNode node;
    Integer level;
    Tuple(){}
    Tuple(TreeNode node,Integer level){
        this.node=node;
        this.level=level;
    }
    TreeNode getNode(){
        return this.node;
    }
    Integer getLevel(){
        return this.level;
    }
}
