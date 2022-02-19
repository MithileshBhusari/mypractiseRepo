package com.mtb.ex;

/**
 * @author MithileshB
 * @created 10/01/2022 - 9:20 PM
 * @project interviewex
 */
public class HasCycleCheck {
    public boolean hasCycle(ListNode head){
        if(head==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;

        while(slow!=fast){
            if(fast==null || fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}
