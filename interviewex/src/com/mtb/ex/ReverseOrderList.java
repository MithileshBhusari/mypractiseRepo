package com.mtb.ex;

/**
 * @author MithileshB
 * @created 22/12/2021 - 8:46 AM
 * @project interviewex
 */
public class ReverseOrderList {

    public static void main(String[] args) {
        ListNode l5=new ListNode(5,null);
        ListNode l4=new ListNode(4,l5);
        ListNode l3=new ListNode(3,l4);

        ListNode l2=new ListNode(2,l3);
        ListNode l1=new ListNode(1,l2);
        ListNode head=l1;


        reverseOrderListM(head);
        traverse(head);

    }
    public static  void traverse(ListNode head  ){
        while(head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
    }

    public static void reverseOrderListM(ListNode head){
            if(head==null || head.next==null)
                return;
            ListNode slow=head;
            ListNode fast=head;
            ListNode prev=head;
            while(fast!=null && fast.next!=null){
                prev=slow;
                slow=slow.next;
                fast=fast.next.next;
            }
            prev.next=null;
            ListNode l1=head;
            ListNode l2=reverse(slow);
            merge(l1,l2);
    }

    private static void merge(ListNode l1, ListNode l2) {
        while(l2!=null){
            ListNode next=l1.next;
            l1.next=l2;
            l1=l2;
            l2=next;
        }
    }

    private static ListNode reverse(ListNode l2) {
        if(l2==null)
            return null;
        ListNode prev=null;
        ListNode curr=l2;
        ListNode next=l2.next;
        while(curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

}
