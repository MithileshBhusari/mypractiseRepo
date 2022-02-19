package com.mtb.ex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author MithileshB
 * @created 27/01/2022 - 11:09 PM
 * @project interviewex
 */
public class BTRightSideView {
    public static List<Integer> rightSideView(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null) return result;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode current_node = queue.poll();
                if(i==0)result.add(current_node.val);
                if(current_node.right!=null)queue.offer(current_node.right);
                if(current_node.left!=null) queue.offer(current_node.left);
            }
        }
        return result;
    }
    public static void main(String [] args){
        TreeNode node=new TreeNode(1,
                new TreeNode(2,null,new TreeNode(5,null,null)),
                new TreeNode(3,null,new TreeNode(4,null,null)));

        List<Integer> integerList = rightSideView(node);
        integerList.forEach(x->System.out.print(x+" "));
    }
}
