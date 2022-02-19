package com.mtb.ex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author MithileshB
 * @created 27/01/2022 - 8:49 PM
 * @project interviewex
 */
public class WidthOfBinaryTreeEx {
   private static  int max_width=0;
    private static Map<Integer,Integer> leftMost_Position=new HashMap<>();
    static class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node,int _num){
            this.node=node;
            this.num=_num;
        }
    }
    public static int widthOfBinaryTree(TreeNode root){
        if(root==null){
            return 0;
        }
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int nmin=q.peek().num;
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                int current_id=q.peek().num-nmin;
                TreeNode node=q.peek().node;
                q.poll();
                if(i==0)first=current_id;
                if(i==size-1) last=current_id;
                if(node.left!=null)
                    q.offer(new Pair(node.left,current_id*2+1));
                if(node.right!=null)
                    q.offer(new Pair(node.right,current_id*2+2));
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
    public static void main(String[] args){
        TreeNode node=new TreeNode(1,new TreeNode(3,new TreeNode(5,null,null),new TreeNode(3,null,null)),
                    new TreeNode(2,null,new TreeNode(9,null,null)));
        System.out.println(widthOfBinaryTree(node));
        System.out.println(widthOfBinaryTreeWithMap(node));
    }

    public static int widthOfBinaryTreeWithMap(TreeNode root){

        get_width(root,0,0);
        return max_width;
    }
    public static void get_width(TreeNode node,int depth,int position){
        if(node==null){
            return ;
        }
        leftMost_Position.computeIfAbsent(depth,x->position);
        max_width=Math.max(max_width,position-leftMost_Position.get(depth)+1);
        get_width(node.left,depth+1,position*2);
        get_width(node.right,depth+1,position*2+1);
    }
}
