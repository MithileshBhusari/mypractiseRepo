package com.mtb.ex;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author MithileshB
 * @created 16/01/2022 - 9:29 PM
 * @project interviewex
 */
public class FindBottomLeftValue {
    public static int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            root=queue.poll();
            if(root.left!=null){
                queue.offer(root.left);
            }
            if(root.right!=null){
                queue.offer(root.right);
            }

        }
        return root.val;
    }
    public static void main(String[] args){

        TreeNode t4=new TreeNode(4);
        TreeNode t2=new TreeNode(2,t4,null);
        TreeNode t7=new TreeNode(7);
        TreeNode t5=new TreeNode(5,t7,null);
        TreeNode t6=new TreeNode(6);
        TreeNode t3=new TreeNode(3,t5,t6);
        TreeNode root=new TreeNode(1,t2,t3);
        System.out.println(findBottomLeftValue(root));
    }
}
