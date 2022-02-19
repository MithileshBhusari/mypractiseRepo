package com.mtb.ex;

import java.util.Stack;

/**
 * @author MithileshB
 * @created 06/12/2021 - 6:56 AM
 * @project interviewex
 */
public class RecursiveCloneStack {
    static Stack<Integer> s=new Stack<>();
    static Stack<Integer> d=new Stack<>();
    public static void main(String[] args) {
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        cloneStack();
    }

    private static void cloneStack() {
        RecursiveCloneStackM();
        System.out.println("Destination:");
        int f=0;
        while(d.size()>0){
            if(f==0){
                System.out.println(d.peek());
                f=1;
            }
            else
                System.out.println(" "+d.peek());
            d.pop();
            System.out.println();
        }
    }

    private static void RecursiveCloneStackM() {
        if(s.size()==0)
            return;
        int val=s.peek();
        s.pop();
        RecursiveCloneStackM();
        d.push(val);
    }

}
