package com.mtb.ex;

import java.util.LinkedList;

/**
 * @author MithileshB
 * @created 16/01/2022 - 9:02 PM
 * @project interviewex
 */
public class SwapPairsEx {
    public static ListNode swapPairs(ListNode head){
        ListNode temp=new ListNode(0);
        temp.next=head;
        ListNode current=temp;
        while(current.next!=null && current.next.next!=null){
            ListNode firstNode=current.next;
            ListNode nextNode=current.next.next;
            firstNode.next=nextNode.next;
            current.next=nextNode;
            current.next.next=firstNode;
            current=firstNode;
        }
        return  temp.next;
    }
    public static void main(String[] args){
        ListNode l4=new ListNode(4,null);
        ListNode l3=new ListNode(3,l4);
        ListNode l2=new ListNode(2,l3);
        ListNode l1=new ListNode(1,l2);

        ListNode resultList=swapPairs(l1);
        while(resultList!=null){
            System.out.print(resultList.val+" ");
            resultList=resultList.next;
        }
    }

}
