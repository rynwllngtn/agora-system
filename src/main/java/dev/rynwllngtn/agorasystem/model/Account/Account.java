package dev.rynwllngtn.agorasystem.model.Account;

import dev.rynwllngtn.agorasystem.model.User;

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
        if(this.owner.isActive()) {
            this.balance = (getBalance() + amount);
        }
    }
}
