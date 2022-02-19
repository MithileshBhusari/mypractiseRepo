package com.mtb.ex;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
/**
 * @author MithileshB
 * @created 08/01/2022 - 8:37 PM
 * @project interviewex
 */
public class SumRootToLeafNumbers {

    private static  int sumToRoot(TreeNode node,int val){
        if(node==null){
            return 0;
        }
        val=(val*10)+node.val;
        if(node.left==null && node.right==null){
            return val;
        }
        return sumToRoot(node.left,val)+sumToRoot(node.right,val);
    }
    public static int sumRootToLeaf(TreeNode root) {
        int rootToLeaf = 0, currNumber = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            root = p.getKey();
            currNumber = p.getValue();

            if (root != null) {
                currNumber = (currNumber << 1) | root.val;
                // if it's a leaf, update root-to-leaf sum
                if (root.left == null && root.right == null) {
                    rootToLeaf += currNumber;
                } else {
                    stack.push(new Pair(root.right, currNumber));
                    stack.push(new Pair(root.left, currNumber));
                }
            }
        }
        return rootToLeaf;
    }
    public static void main(String[] args){

        TreeNode t7=new TreeNode(7);
        TreeNode t2=new TreeNode(2);
        TreeNode t11=new TreeNode(6,t7,t2);
        TreeNode t13=new TreeNode(9);
        TreeNode t1=new TreeNode(1);
        TreeNode t14=new TreeNode(4,null,t1);

        TreeNode t8=new TreeNode(8,t13,t14);
        TreeNode t4=new TreeNode(4,t11,null);
        TreeNode t5=new TreeNode(5,t4,t8);

        TreeNode n1=new TreeNode(1);
TreeNode node=new TreeNode(0,n1,null);
        System.out.println("sumToRoot: "+sumToRoot(t5,0));
        System.out.println(sumRootToLeaf(t5));
    }
}
