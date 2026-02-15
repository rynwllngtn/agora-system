package dev.rynwllngtn.agorasystem.model.Account;

import dev.rynwllngtn.agorasystem.model.User;
import dev.rynwllngtn.agorasystem.model.exception.DomainException;
import dev.rynwllngtn.agorasystem.model.exception.InactiveAccountException;
import dev.rynwllngtn.agorasystem.model.exception.InsufficientFundsException;
import dev.rynwllngtn.agorasystem.model.exception.InsufficientTransactionLimitException;

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
    public void makeWithdrawal(double amount) throws DomainException {
        double taxedAmount = amount + (amount * transactionTax);
        if(!this.owner.isActive()) {
            throw new InactiveAccountException("Withdrawal Erro: Inactive user!\n");
        }
        if(this.balance < taxedAmount) {
            throw new InsufficientFundsException("Withdrawal Erro: Insufficient funds to make this withdrawal!\n");
        }
        if(transactionLimit < taxedAmount) {
            throw new InsufficientTransactionLimitException("Withdrawal Erro: Insufficient limit transaction to make this withdrawal!\n");
        }
        super.makeWithdrawal(taxedAmount);
        this.transactionLimit -= taxedAmount;
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
