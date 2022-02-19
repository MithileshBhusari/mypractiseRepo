package com.mtb.ex.dip;

/**
 * @author MithileshB
 * @created 01/12/2021 - 8:25 AM
 * @project interviewex
 */
public class ShoppingMall {
    private DebitCard debitCard;

    private BankCard bankCard;
    public ShoppingMall(BankCard bankCard){
        this.bankCard=bankCard;
    }

    public void doPurchaseSomething(long amount){
        debitCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        BankCard bankCard=new DebitCard();
   //     DebitCard debitCard=new DebitCard();
    //CreditCard creditCard=new CreditCard();
        ShoppingMall shoppingMall=new ShoppingMall(bankCard);
        shoppingMall.doPurchaseSomething(5000);
    }
}
