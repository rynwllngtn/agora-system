package dev.rynwllngtn.agorasystem.model.Account;

import dev.rynwllngtn.agorasystem.model.User;

public class CheckingAccount extends Account {
    private double transactionLimit = 20000.0;
    private final double transactionLimitFinal = transactionLimit;
    private final double transactionTax = 0.02;

    public CheckingAccount(User owner) {
        super(owner);
    }

    public double getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(double transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public double getTransactionTax() {
        return transactionTax;
    }

    public void makeMonthlyPayment() {
        this.balance -= 70.0;
    }

    @Override
    public void makeWithdrawal(double amount) {
        double taxedAmount = amount + (amount * transactionTax);
        if(this.owner.isActive()) {
            if(this.balance >= taxedAmount && transactionLimit >= taxedAmount) {
                super.makeWithdrawal(taxedAmount);
                this.transactionLimit -= taxedAmount;
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
