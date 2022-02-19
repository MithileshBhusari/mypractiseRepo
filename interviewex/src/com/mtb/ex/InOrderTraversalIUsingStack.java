package com.mtb.ex;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
/**
 * @author MithileshB
 * @created 02/01/2022 - 7:26 PM
 * @project interviewex
 */

class InOrderNode{
    int data;
    InOrderNode left,right;
    public InOrderNode(int item){
        this.data=item;
        left=right=null;
    }

}
public class InOrderTraversalIUsingStack {

        InOrderNode root;
        //public  List<Integer> inOrderTraversal(InOrderNode root){
        public  List<Integer> inOrderTraversal(){
            Stack<InOrderNode> stack=new Stack<>();
            List<Integer> output_arr=new ArrayList<>();

            if(root==null){
                return output_arr;
            }
            InOrderNode current=root;

            while(current!=null || !stack.isEmpty()){
                while(current!=null){
                        stack.push(current);
                        current=current.left;
                }
                current=stack.pop();
                output_arr.add(current.data);
                current=current.right;
            }
            return output_arr;
        }

        public static void main(String[] args){
            InOrderTraversalIUsingStack tree=new InOrderTraversalIUsingStack();
            tree.root=new InOrderNode(1);
            tree.root.left=new InOrderNode(2);
            tree.root.right=new InOrderNode(3);
            tree.root.left.left=new InOrderNode(4);
            tree.root.left.right=new InOrderNode(5);
            tree.root.right.left=new InOrderNode(6);

            List<Integer> list=tree.inOrderTraversal();

            for(Integer i:list){
                System.out.print(i+"->");
            }


        }
}
