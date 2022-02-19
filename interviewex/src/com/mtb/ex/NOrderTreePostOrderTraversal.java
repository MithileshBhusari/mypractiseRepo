package com.mtb.ex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * @author MithileshB
 * @created 31/12/2021 - 10:22 PM
 * @project interviewex
 */
class Node{
    public int val;
    public List<Node> children=new ArrayList<>();
    public Node(){}
    public Node(int _val)
    {
        val = _val;
    }

    public Node(int val,List<Node> children){
        this.val=val;
        this.children=children;
    }
}
public class NOrderTreePostOrderTraversal {

    public static List<Integer> postOrder(Node root){
        LinkedList<Node> stack=new LinkedList<>();
        LinkedList<Integer> output_arr=new LinkedList<>();

        if(root==null){
            return output_arr;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            Node node=stack.pollLast();
            output_arr.addFirst(node.val);
            for(Node child:node.children){
                stack.add(child);
            }
        }
        return output_arr;
    }

    public static void main(String[] args){
        Node root = new Node(1);

        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));

        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));

        List<Integer> result = postOrder(root);

        for(Integer i:result){
            System.out.print(i+"->");
        }

    }
}
