package com.mtb.ex;

/**
 * @author MithileshB
 * @created 07/01/2022 - 8:00 AM
 * @project interviewex
 */
public class PalindromeListEx {

    public static boolean isPalindromeList(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow=reversed(slow);
        fast=head;

        while(slow!=null){
            if(slow.val!=fast.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }

    public static ListNode reversed(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode next=head;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
    public static void main(String[] args){
        ListNode listNode1=new ListNode(1,null);
        ListNode listNode2=new ListNode(2,listNode1);
        ListNode listNode3=new ListNode(3,listNode2);
        ListNode listNode4=new ListNode(3,listNode3);
        ListNode listNode5=new ListNode(2,listNode4);
        ListNode listNode6=new ListNode(1,listNode5);

        System.out.println(isPalindromeList(listNode6));
    }
}
