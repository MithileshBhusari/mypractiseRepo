package com.mtb.ex;

import java.util.Stack;

/**
 * @author MithileshB
 * @created 10/01/2022 - 11:44 PM
 * @project interviewex
 */
public class DeleteMiddleNodeEx {
    public static ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }

        ListNode slow_node=head;
        ListNode fast_node=head;
        ListNode current_head=head;

        ListNode prev_to_slow=null;
        while(fast_node!=null && fast_node.next!=null){
            prev_to_slow=slow_node;
            slow_node=slow_node.next;
            fast_node=fast_node.next.next;
        }
        prev_to_slow.next=slow_node.next;
        return current_head;
    }

    public static ListNode removeNthNodeFromEnd(ListNode head,int n){
        if(n==1 || head==null || head.next==null){
            return null;
        }
        ListNode current_head=head;
        ListNode prev_node=head;
        ListNode current_node=head;
        int i=0;

        Stack<ListNode> stackList=new Stack<>();
        while(current_node!=null){
            stackList.add(current_node);
            current_node=current_node.next;
        }
        int length=stackList.size();
        int j=1;
        ListNode next_node=null;
        while(j<=n){
            next_node=stackList.pop();
            j++;
        }
        while(current_node!=null || current_node.next!=null){
            while(i<=n){
                prev_node=current_node;
                current_node=current_node.next;
            }
            prev_node.next=current_node.next;
        }
        return prev_node;
    }
    public static void main(String[] args){
    /*    ListNode t5=new ListNode(5);
        ListNode t4=new ListNode(4,t5);
        ListNode t3=new ListNode(3,t4);
        ListNode t2=new ListNode(2,t3);*/
        ListNode t1=new ListNode(1,null);

        ListNode resultNode=deleteMiddle(t1);
        while(resultNode!=null){
            System.out.print(resultNode.val+" ");
            resultNode=resultNode.next;
        }

    }
}
