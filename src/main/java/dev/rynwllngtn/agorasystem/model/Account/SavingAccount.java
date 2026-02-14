package dev.rynwllngtn.agorasystem.model.Account;

import dev.rynwllngtn.agorasystem.model.User;

public class SavingAccount extends Account {
    private double transactionLimit = 5000.0;
    private final double transactionLimitFinal = transactionLimit;
    private final double interestRate = 0.01;

    public SavingAccount(User owner) {
        super(owner);
    }

    public double getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(double transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void applyMonthlyInterest() {
        this.balance += (getBalance() * interestRate);
    }

    @Override
    public void makeWithdrawal(double amount) {
        if(this.owner.isActive()) {
            if(this.balance >= amount && transactionLimit >= amount) {
                super.makeWithdrawal(amount);
                this.transactionLimit -= amount;
            }
        }
    }

    @Override
    public String toString() {
        return "-----Account-----\n" +
                "Owner: " + owner.getUserName() + "\n" +
                "UserID: " + accountID + "\n" +
                "Balance: " + balance +  "\n" +
                "Transaction Limit: " + transactionLimit +  " / " + transactionLimitFinal + "\n" +
                "-----------------";
    }
}
