package com.mtb.ex;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author MithileshB
 * @created 13/01/2022 - 10:28 PM
 * @project interviewex
 */
public class PruneTreeEx {
    public static TreeNode pruneTree(TreeNode root){
        if(containsOne(root)) {
        return root;
        }else {
            return null;
        }
    }

    private static boolean containsOne(TreeNode node) {
        if(node==null){
            return false;
        }
        boolean left_contains=containsOne( node.left);
        boolean right_contains=containsOne(node.right);

        if(!left_contains){
            node.left=null;
        }
        if(!right_contains){
            node.right=null;
        }
        return node.val==1|| left_contains ||right_contains;
    }

    public static void main(String[] args){
        TreeNode zero=new TreeNode(0);
        TreeNode zeroRoot=new TreeNode(1,zero,null);
        TreeNode oneRight=new TreeNode(1);
        TreeNode oneoneleftRoot=new TreeNode(1,zeroRoot,oneRight);
        TreeNode zeroRightLeft=new TreeNode(0);
        TreeNode zeroRightRight=new TreeNode(1);
        TreeNode oneoneRightRoot=new TreeNode(0,zeroRightLeft,zeroRightRight);
        TreeNode root=new TreeNode(1,oneoneleftRoot,oneoneRightRoot);
        TreeNode ex=new TreeNode(0,null,new TreeNode(0,new TreeNode(0),new TreeNode(0)));

        System.out.println("Before tree Pruning");
      //  inOrder(root);
       // System.out.println("printBFSTree ex\n");
        printBFSTree(ex);
        System.out.println();
        System.out.println("After tree Pruning");
        TreeNode resultNode=pruneTree(ex);

        //inOrder(resultNode);

  //      System.out.println("printBFSTree ex\n");
        printBFSTree(resultNode);
    }

    private static void printBFSTree(TreeNode node){
        if(node==null){
            return ;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            TreeNode current=queue.peek();
            System.out.print(current.val+" ");
            if(current.left!=null){
                queue.add(current.left);
            }
            if(current.right!=null){
                queue.add(current.right);
            }
            queue.remove();
        }
    }

    private static void inOrder(TreeNode resultNode) {
        if(resultNode==null){
            return;
        }
        inOrder(resultNode.left);
        System.out.print(resultNode.val+" ");
        inOrder(resultNode.right);
    }
}
