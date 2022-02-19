package com.mtb.ex;

/**
 * @author MithileshB
 * @created 08/01/2022 - 5:53 PM
 * @project interviewex
 */

public class CheckIsSymmetric {

    public static boolean isSymmetric(TreeNode root){
        return isMirror(root,root);
    }

    public static boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1==null && t2==null){
            return true;
        }
        if(t1==null || t2==null) {
            return false;
        }
        return (t1.val==t2.val)&& isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }

    public static void main(String[] args){
        TreeNode tleft3=new TreeNode(3);
        TreeNode tright4=new TreeNode(4);
        TreeNode tleft2=new TreeNode(2,tleft3,tright4);
        TreeNode tleft4=new TreeNode(5);
        TreeNode tright3=new TreeNode(3);
        TreeNode tright2=new TreeNode(2,tleft4,tright3);
        TreeNode root=new TreeNode(1,tleft2,tright2);

        System.out.println("isSymmetric: "+isSymmetric(root));
    }
}
