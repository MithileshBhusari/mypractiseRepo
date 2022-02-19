package com.mtb.ex;

/**
 * @author MithileshB
 * @created 05/02/2022 - 12:37 PM
 * @project interviewex
 */

public class MethodOverloadingTest1 {


    public void method1(String a){
        System.out.println("a");
    }
    public void method1(Object a){
        System.out.println("b");
    }

    public static void main(String[] args) {
         MethodOverloadingTest1 a=new MethodOverloadingTest1();
        a.method1(null);
    }
}
