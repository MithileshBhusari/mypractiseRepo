package com.mtb.ex;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author MithileshB
 * @created 02/01/2022 - 8:04 PM
 * @project interviewex
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){

    }
    TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
public class BinaryTreePostOrderTraversal {
    TreeNode root;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);

        List<Integer> linkedList=binaryTreePostOrder(root);
        for(Integer i:linkedList){
            System.out.print(i+"->");
        }
        System.out.println("null");
    }

    private static List<Integer> binaryTreePostOrder(TreeNode root) {
        //Stack<TreeNode> stack=new Stack<>();
        LinkedList<TreeNode> stack=new LinkedList<>();
        LinkedList<Integer> postOrderList=new LinkedList<>();

        if(root==null){
            return postOrderList;
        }
        stack.add(root);
        //while(root!=null || !stack.isEmpty()){
            while(!stack.isEmpty()){
                TreeNode treeNode = stack.pollLast();
                postOrderList.addFirst(treeNode.val);
                if(treeNode.left!=null) {
                    stack.add(treeNode.left);
                }
                if(treeNode.right!=null) {
                    stack.add(treeNode.right);
                }
            }
            return postOrderList;
        }

}
