package com.mtb.ex;

import java.sql.SQLOutput;

/**
 * @author MithileshB
 * @created 09/01/2022 - 9:04 PM
 * @project interviewex
 */
public class SplitListToParts {
    public static ListNode[] splitListToParts(ListNode head,int k){
        ListNode[] resultList=new ListNode[k];
        int listLength=0;
        ListNode temp=head;
        while(temp!=null){
            listLength++;
            temp=temp.next;
        }
        int div=listLength/k;
        int rem=listLength%k;

        int i=0;
        ListNode prev=null;
                ListNode node=head;
        while(node!=null && i<k){
            resultList[i]=node;
            for(int j=0;j<div+(rem>0?1:0);j++){
                prev=node;
                node=node.next;
            }
            prev.next=null;
            i++;
            rem--;
        }
        return resultList;
    }

    public static void main(String[] args){
        ListNode t5=new ListNode(5);
        ListNode t4=new ListNode(4,t5);
        ListNode t3=new ListNode(3,t4);
        ListNode t2=new ListNode(2,t3);
        ListNode t1=new ListNode(1,t2);

        ListNode[] result=splitListToParts(t1,2);
        for(ListNode node:result){
            if(node==null){
                System.out.print("null");
                continue;
            }
            System.out.print("[");
            while(node!=null){
                System.out.print(node.val+" ");
                node=node.next;
            };
            System.out.print("]");
        }
    }
}
