package com.mtb.ex;

import org.w3c.dom.NodeList;

/**
 * @author MithileshB
 * @created 21/12/2021 - 8:28 AM
 * @project interviewex
 */
public class AddTwoNumbersLL {

    ListNode head;
    public static void main(String[] args) {
         AddTwoNumbersLL l1 = new AddTwoNumbersLL();
        l1.insert(3);
        l1.insert(4);
        l1.insert(2);
        AddTwoNumbersLL l2 = new AddTwoNumbersLL();
        l2.insert(4);
        l2.insert(6);
        l2.insert(5);
        AddTwoNumbersLL l3 = new AddTwoNumbersLL();

    //    ListNode head = sum(l1.head, l2.head);


        ListNode head= addTwoNumbers(l1.head,l2.head);
        System.out.println(head.toString());
        l3.traverse(head);
        System.out.print("Null");
    }
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
            int carry=0;
        ListNode dummy=new ListNode();
        ListNode temp=dummy;

            while(l1!=null || l2!=null ||carry==1){
                int sum=0;
                if(l1!=null){
                    sum+=l1.val;
                    l1=l1.next;
                }
                if(l2!=null){
                    sum+=l2.val;
                    l2=l2.next;
                }
                sum+=carry;
                carry=sum/10;
                ListNode node=new ListNode(sum%10);
                temp.next=node;
                temp=temp.next;
            }
            return dummy.next;
    }

    public void traverse(ListNode head  ){
        while(head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
    }
    void insert(int x){
        ListNode node=new ListNode(x);
        if (head == null) {
            head=node;
        }else{
            node.next=head;
            head=node;
        }
    }
    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head=prev;
        return head;
    }

    public static ListNode sum(ListNode l1,ListNode l2){
        if(l2==null)
            return l1;
        if(l1==null)
            return l2;
        l1=reverse(l1);
        l2=reverse(l2);

        ListNode head=l1;
        ListNode prev=null;
        int c=0,sum;
        while(l1!=null && l2 !=null){
            sum=c+l1.val+l2.val;
            l1.val=sum%10;
            c=sum/10;
            prev=l1;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1!=null ||l2!=null){
            if(l2!=null )
                prev.next=l2;
            l1=prev.next;
            while(l1!=null){
                sum=c+ l1.val;
                l1.val=sum%10;
                c=sum/10;
                prev=l1;
                l1=l1.next;
            }
        }
        if(c>0)
            prev.next=new ListNode(c);
        return reverse(head);
    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }


}
