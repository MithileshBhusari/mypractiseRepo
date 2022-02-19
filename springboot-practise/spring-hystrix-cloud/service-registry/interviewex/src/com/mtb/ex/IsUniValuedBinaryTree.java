package com.mtb.ex;

/**
 * @author MithileshB
 * @created 08/01/2022 - 6:10 PM
 * @project interviewex
 */
public class IsUniValuedBinaryTree {


    public static void main(String[] args){
        TreeNode tleft3=new TreeNode(1);
        TreeNode tright4=new TreeNode(1);
        TreeNode tleft2=new TreeNode(1,tleft3,tright4);
        //com.mtb.ex.TreeNode tleft4=new com.mtb.ex.TreeNode(5);
        TreeNode tright3=new TreeNode(1);
        TreeNode tright2=new TreeNode(1,null,tright3);
        TreeNode root=new TreeNode(1,tleft2,tright2);

        System.out.println("isUniValuedTree: "+isUniValuedTree(root));
    }

    public static boolean isUniValuedTree(TreeNode root){
        if(root==null) {
            return true;
        }

        if(root.left!=null && root.val!=root.left.val){
            return false;
        }
        if(root.right!=null && root.val!=root.right.val){
            return false;
        }
        return isUniValuedTree(root.left) && isUniValuedTree(root.right);
    }
}
