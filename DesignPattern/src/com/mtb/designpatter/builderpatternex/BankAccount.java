package com.mtb.designpatter.builderpatternex;

/**
 * @author MithileshB
 * @created 13/06/2020 - 8:14 PM
 * @project DesignPattern
 */
public class BankAccount {
    private long accountNumber;
    private String owner;
    private String branch;
    private double balance;
    private double interestRate;

    public static class Builder{
        private long accountNumber;
        private String owner;
        private String branch;
        private double balance;
        private double interestRate;

        public Builder(long accountNumber){
            this.accountNumber=accountNumber;
        }

        public Builder withOwner(String owner){
            this.owner=owner;
            return  this;
        }

        public Builder atRate(double interestRate){
            this.interestRate=interestRate;
            return this;
        }
        public Builder atBranch(String branch){
            this.branch=branch;
            return this;
        }

        public Builder openingBalance(double balance){
            this.balance=balance;
            return this;
        }

        public BankAccount build(){
            BankAccount bankAccount = new BankAccount();
            bankAccount.accountNumber=this.accountNumber;
            bankAccount.balance=this.balance;
            bankAccount.branch=this.branch;
             bankAccount.interestRate=this.interestRate;
             bankAccount.owner=this.owner;
             return bankAccount;
        }


    }
    private BankAccount(){

    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", owner='" + owner + '\'' +
                ", branch='" + branch + '\'' +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                '}';
    }
}

class Demo{
    public static void main(String[] args) {
        BankAccount bankAccount=new BankAccount.Builder(1234L)
                .atBranch("Magarpatta")
                .atRate(2.5)
                .openingBalance(1000)
                .withOwner("Mithilesh")
                .build();
        System.out.println(bankAccount);
    }
}