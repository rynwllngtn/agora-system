package dev.rynwllngtn.agorasystem.model.Account;

import dev.rynwllngtn.agorasystem.model.User;
import dev.rynwllngtn.agorasystem.model.exception.DomainException;

public abstract class Account {
    protected final User owner;
    protected final int accountID;
    protected double balance;

    public static int nextID = 1;
    public Account(User owner) {
        this.owner = owner;
        this.accountID = nextID++;
        this.balance = 0.0;
    }

    public int getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void makeDeposit(double amount) {
        this.balance = (getBalance() + amount);
    }

    public void makeWithdrawal(double amount) throws DomainException {
        this.balance = (getBalance() - amount);
    }
}
