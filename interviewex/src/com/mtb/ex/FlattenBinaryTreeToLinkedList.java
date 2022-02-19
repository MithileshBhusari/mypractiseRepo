package com.mtb.ex;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author MithileshB
 * @created 27/01/2022 - 10:21 PM
 * @project interviewex
 */
public class FlattenBinaryTreeToLinkedList {

    public static void flatten(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> stack=new Stack();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current_node=stack.pop();
            if(current_node.right!=null){
                stack.push(current_node.right);
            }
            if(current_node.left!=null){
                stack.push(current_node.left);
            }
            if(!stack.isEmpty()){
                current_node.right=stack.peek();
            }
            current_node.left=null;
        }
    }
    public static  void traverseBFS(TreeNode node){
        if(node==null) return;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()){
            //t
            TreeNode current_node = queue.peek();
            System.out.print(current_node.val+" ");
            if(current_node.left!=null)queue.add(current_node.left);
            if(current_node.right!=null)queue.add(current_node.right);
            queue.remove();
        }
    }
    public static void main(String[] args){
        TreeNode node=new TreeNode(1,new TreeNode(2,new TreeNode(3,null,null),new TreeNode(4,null,null)),
                                    new TreeNode(5,null,new TreeNode(6,null,null)));
        traverseBFS(node);
       flatten(node);
        traverseBFS(node);

    }
}
