package com.mtb.ex;

/**
 * @author MithileshB
 * @created 16/01/2022 - 10:44 PM
 * @project interviewex
 */
public class PartitionEx {
    public static ListNode partition(ListNode head,int x){
        ListNode beforeX=new ListNode(0);
        ListNode before=beforeX;
        ListNode afterX=new ListNode(0);
        ListNode after=afterX;
        while(head!=null){
            if(head.val<x){
                before.next=head;
                before=before.next;
            }else{
                after.next=head;
                after=after.next;
            }
            head=head.next;
        }
        after.next=null;
        before.next=afterX.next;
        return beforeX.next;
    }
    public static void main(String[] args){

        ListNode listNode=new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2))))));
        ListNode resultNode=partition(listNode,3);
        while(resultNode!=null){
            System.out.print(resultNode.val+ " ");
            resultNode=resultNode.next;
        }
    }
}
