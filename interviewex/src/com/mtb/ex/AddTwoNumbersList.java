package com.mtb.ex;

/**
 * @author MithileshB
 * @created 08/02/2022 - 8:12 PM
 * @project interviewex
 */
public class AddTwoNumbersList {
        public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
            ListNode dummy_head=new ListNode(0);
            ListNode l3=dummy_head;

            int carry=0;
            while(l1!=null || l2!=null){
                 l1.val=(l1!=null)?l1.val:0;
                 l2.val=(l2!=null)?l2.val:0;

                int current_sum=l1.val+l2.val+carry;
                carry=current_sum/10;
                int last_digit=current_sum%10;

                ListNode new_node=new ListNode(last_digit);
                l3.next=new_node;
                if(l1!=null) l1=l1.next;
                if(l2!=null) l2=l2.next;
                l3=l3.next;
            }
            if(carry>0){
                ListNode new_node=new ListNode(carry);
                l3.next=new_node;
                l3=l3.next;
            }
	return dummy_head.next;
    }

    public static void main(String[] args) {
        ListNode l=addTwoNumbers(new ListNode(2,new ListNode(4,new ListNode(3,null))),new ListNode(5,new ListNode(6,new ListNode(4,null))));
        while(l!=null){
            System.out.print(l.val+" ");
            l=l.next;
        }
    }
}
