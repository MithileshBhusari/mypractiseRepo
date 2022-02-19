package com.mtb.ex.dip;

/**
 * @author MithileshB
 * @created 01/12/2021 - 8:23 AM
 * @project interviewex
 */
public class CreditCard implements BankCard {

    @Override
    public void doTransaction(long amount){
        System.out.println("Payment using Credit Card");
    }
}
