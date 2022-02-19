package com.mtb.ex;

/**
 * @author MithileshB
 * @created 17/01/2022 - 12:26 AM
 * @project interviewex
 */
public class DistributeCoinsEx {
    static int num_moves;
    public static int distributeCoins(TreeNode root){
        num_moves=0;
        give_coins(root);
        return num_moves;
    }
    private static  int give_coins(TreeNode root){
        if(root==null) return 0;
        int left=give_coins(root.left);
        int right=give_coins(root.right);
        num_moves+=Math.abs(left)+Math.abs(right);
        return root.val+left+right-1;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1,new TreeNode(0,null,new TreeNode(3)),new TreeNode(0));
        TreeNode root1=new TreeNode(0,new TreeNode(3),new TreeNode(0));
        System.out.println(distributeCoins(root1));
    }
}
