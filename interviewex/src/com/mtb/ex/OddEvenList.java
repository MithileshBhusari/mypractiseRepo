package com.mtb.ex;

import java.util.LinkedList;

/**
 * @author MithileshB
 * @created 09/01/2022 - 8:27 PM
 * @project interviewex
 */
public class OddEvenList {
    public static ListNode oddEvenList(ListNode head){
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=even;

        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }


    public static void main(String[] args){
        ListNode t5=new ListNode(5);
        ListNode t4=new ListNode(4,t5);
        ListNode t3=new ListNode(3,t4);
        ListNode t2=new ListNode(2,t3);
        ListNode t1=new ListNode(1,t2);

        ListNode result=oddEvenList(t1);
        while(result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }

}
