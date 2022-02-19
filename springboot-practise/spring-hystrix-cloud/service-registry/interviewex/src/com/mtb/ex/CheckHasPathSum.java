package com.mtb.ex;

import java.util.Stack;

/**
 * @author MithileshB
 * @created 08/01/2022 - 7:48 PM
 * @project interviewex
 */
public class CheckHasPathSum {
    public static boolean hasPathSum(TreeNode root,int sum){
        Stack<TreeNode> node_stack=new Stack();
        Stack<Integer> sum_stack=new Stack();

        node_stack.add(root);
        sum_stack.add(sum-root.val);
        while(!node_stack.isEmpty()){
            TreeNode current_node=node_stack.pop();
            int current_sum=sum_stack.pop();
            if(current_node.left==null && current_node.right==null && current_sum==0){
                return true;
            }
            if(current_node.left!=null){
                node_stack.add(current_node.left);
                sum_stack.add(current_sum-current_node.left.val);
            }
            if(current_node.right!=null){
                node_stack.add(current_node.right);
                sum_stack.add(current_sum-current_node.right.val);
            }
        }
        return false;
    }
    public static void main(String[] args){
        TreeNode t7=new TreeNode(7);
        TreeNode t2=new TreeNode(2);
        TreeNode t11=new TreeNode(11,t7,t2);
        TreeNode t13=new TreeNode(13);
        TreeNode t1=new TreeNode(1);
        TreeNode t14=new TreeNode(4,null,t1);

        TreeNode t8=new TreeNode(8,t13,t14);
        TreeNode t4=new TreeNode(4,t11,null);
        TreeNode t5=new TreeNode(5,t4,t8);

        System.out.println("hasPathSum: "+hasPathSum(t5,22));
    }

}
