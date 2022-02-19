package com.mtb.ex.dip;

/**
 * @author MithileshB
 * @created 01/12/2021 - 8:24 AM
 * @project interviewex
 */
public class DebitCard implements BankCard{

    @Override
    public void doTransaction(long amount){
        System.out.println("Payment using Debit Card");
    }
}
