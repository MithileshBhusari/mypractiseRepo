package com.mtb.ex;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author MithileshB
 * @created 27/01/2022 - 7:27 PM
 * @project interviewex
 */
public class CheckCompletenessOfBinaryTree {
        public static boolean isComplete(TreeNode root){
            boolean end=false;
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode current_node=queue.poll();
                if(current_node==null){
                    end=true;
                }else{
                    if(end) return false;
                    queue.offer(current_node.left);
                    queue.offer(current_node.right);
                }
            }
            return true;
        }
        public static void main(String[] args){
            TreeNode node=new TreeNode(1,new TreeNode(2,new TreeNode(4,null,null),new TreeNode(5,null,null)),
                    new TreeNode(3,new TreeNode(6,null,null),null));

            TreeNode node1=new TreeNode(1,new TreeNode(2,new TreeNode(4,null,null),new TreeNode(5,null,null)),
                    new TreeNode(3,null,new TreeNode(7,null,null)));
            System.out.println(isComplete(node));
            System.out.println(isComplete(node1));
        }
}
