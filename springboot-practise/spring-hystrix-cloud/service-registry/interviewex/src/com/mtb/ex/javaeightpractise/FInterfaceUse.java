package com.mtb.ex.javaeightpractise;

/**
 * @author MithileshB
 * @created 17/01/2022 - 1:24 AM
 * @project interviewex
 */
public class FInterfaceUse {
    public static void main(String[] args){
        FInterface total=(a,b)->(a*b);
        System.out.println(total.multiply(10,20));
    }
}
