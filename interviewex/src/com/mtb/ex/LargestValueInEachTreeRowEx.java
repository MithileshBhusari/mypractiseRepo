package com.mtb.ex;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
/**
 * @author MithileshB
 * @created 14/01/2022 - 8:19 PM
 * @project interviewex
 */
public class LargestValueInEachTreeRowEx {

        public static List<Integer> largestValues(TreeNode root){
            List<Integer> largestVal=new ArrayList<>();
            helper_method(root,largestVal,0);
            return largestVal;
        }
        public static void helper_method(TreeNode node,List<Integer> largestVal,int level){
            if(node==null) return;
            if(level==largestVal.size())largestVal.add(node.val);
            else
            {
                largestVal.set(level,Math.max(largestVal.get(level),node.val));
            }
            helper_method(node.left,largestVal,level+1);
            helper_method(node.right,largestVal,level+1);
        }

        public static void main(String[] args){
            TreeNode t5=new TreeNode(5);
            TreeNode t3=new TreeNode(3);
            TreeNode rootOf53=new TreeNode(3,t5,t3);
            TreeNode t9=new TreeNode(9);
            TreeNode t2=new TreeNode(2,null,t9);
            TreeNode root=new TreeNode(1,rootOf53,t2);

            bfsTraversal(root);
            List<Integer> list=largestValues(root);
            System.out.println();
            System.out.println("Largest Values are \n");
            for(Integer i:list){
                System.out.print(i+" ");
            }
        }

    private static void bfsTraversal(TreeNode root) {
            if(root==null) return;
            Queue<TreeNode> queue=new ArrayDeque<>();
            queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.peek();
            System.out.print(currentNode.val+" ");
            if(currentNode.left!=null) bfsTraversal(currentNode.left);
            if(currentNode.right!=null) bfsTraversal(currentNode.right);
            queue.remove();
        }

    }
}
