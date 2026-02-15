package dev.rynwllngtn.agorasystem.model.Account;

import dev.rynwllngtn.agorasystem.model.User;
import dev.rynwllngtn.agorasystem.model.exception.DomainException;
import dev.rynwllngtn.agorasystem.model.exception.InactiveAccountException;
import dev.rynwllngtn.agorasystem.model.exception.InsufficientFundsException;
import dev.rynwllngtn.agorasystem.model.exception.InsufficientTransactionLimitException;

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
    public void makeWithdrawal(double amount) throws DomainException {
        if(!this.owner.isActive()) {
            throw new InactiveAccountException("Withdrawal Erro: Inactive user!\n");
        }
        if(this.balance < amount) {
            throw new InsufficientFundsException("Withdrawal Erro: Insufficient funds to make this withdrawal!\n");
        }
        if(transactionLimit < amount) {
            throw new InsufficientTransactionLimitException("Withdrawal Erro: Insufficient limit transaction to make this withdrawal!\n");
        }
        super.makeWithdrawal(amount);
        this.transactionLimit -= amount;
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
