package com.mtb.ex;

/**
 * @author MithileshB
 * @created 07/01/2022 - 6:54 AM
 * @project interviewex
 */
public class InvertBinaryTreeS {

        public TreeNode invertTree(TreeNode root){

            if(root==null){
                return root;
            }
            TreeNode left=invertTree(root.left);
            TreeNode right=invertTree(root.right);

            //swap
            root.right=left;
            root.left=right;

            return root;
        }

        public TreeNode inOrder(TreeNode root){
            if(root==null){
                return root;
            }
            inOrder(root.left);
            System.out.print(root.val+"->");
            inOrder(root.right);
            return  root;
        }
        public static void main(String[] args){

            InvertBinaryTreeS invertBinaryTreeS=new InvertBinaryTreeS();
            TreeNode root=new TreeNode(4);
            root.left=new TreeNode(2);
            root.right=new TreeNode(7);
            root.left.left=new TreeNode(1);
            root.left.right=new TreeNode(3);
            root.right.left=new TreeNode(6);
            root.right.right=new TreeNode(9);

            System.out.println("InOrder Traversal of initial tree");
            invertBinaryTreeS.inOrder(root);


            TreeNode node=invertBinaryTreeS.invertTree(root);
            System.out.println("InOrder Traversal of invert Tree");
            invertBinaryTreeS.inOrder(node);

        }
}
