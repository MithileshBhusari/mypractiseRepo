package com.mtb.ex;

import java.util.Stack;

/**
 * @author MithileshB
 * @created 16/01/2022 - 11:06 PM
 * @project interviewex
 */
public class RangeSumBST {
    public static int rangeSumBST(TreeNode root,int low,int high){
        Stack<TreeNode> stack=new Stack<>();
        int sum=0;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current=stack.pop();
            if(current!=null) {
                if (current.val >= low && current.val<=high) {
                    sum+=current.val;
                }
                if(current.val>low){
                    stack.push(current.left);
                }
                if(current.val<high){
                    stack.push(current.right);
                }
            }
        }
        return sum;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(10,
                                                                    new TreeNode(5,
                                                                                                        new TreeNode(3),
                                                                                                        new TreeNode(7)),
                                                                    new TreeNode(15,
                                                                                                        null,
                                                                                                         new TreeNode(18)));

        TreeNode t2=new TreeNode(10,
                                                                new TreeNode(5,
                                                                                                    new TreeNode(3,
                                                                                                                                    new TreeNode(1),
                                                                                                                            null),
                                                                                                    new TreeNode(7,
                                                                                                                                new TreeNode(6,null,null),null)),
                                                                new TreeNode(15,new TreeNode(13),new TreeNode(18)));
        //System.out.println(rangeSumBST(root,7,15));
        System.out.println(rangeSumBST(t2,6,10));
    }
}
