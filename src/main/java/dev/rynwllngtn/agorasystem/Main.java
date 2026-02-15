package dev.rynwllngtn.agorasystem;

import dev.rynwllngtn.agorasystem.model.Account.CheckingAccount;
import dev.rynwllngtn.agorasystem.model.Account.SavingAccount;
import dev.rynwllngtn.agorasystem.model.User;
import dev.rynwllngtn.agorasystem.model.exception.DomainException;
import dev.rynwllngtn.agorasystem.model.exception.InsufficientFundsException;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(
                "User",
                "20000101",
                "user1email@domain.com",
                "0001112223",
                "1234567890");

        System.out.println(user1.toString());

        //Creating Bank accounts
        CheckingAccount user1checking = new CheckingAccount(user1);
        SavingAccount user1saving = new SavingAccount(user1);


        //Trying withdrawal without funds
        System.out.println("\nChecking withdrawal without funds");
        try {
            user1checking.makeWithdrawal(20000.0);
        } catch (DomainException e) {
            System.out.print(e.getMessage());
        }

        try {
            user1saving.makeWithdrawal(5001.0);
        } catch (DomainException e) {
            System.out.print(e.getMessage());
        }


        //Trying withdrawal beyond limits
        user1checking.makeDeposit(25000.0);
        user1saving.makeDeposit(25000.0);
        System.out.println("\nChecking withdrawal beyond limits");
        try {
            user1checking.makeWithdrawal(20000.0);
        } catch (DomainException e) {
            System.out.print(e.getMessage());
        }

        try {
            user1saving.makeWithdrawal(5001.0);
        } catch (DomainException e) {
            System.out.print(e.getMessage());
        }


        //Trying withdrawal in deactivated account
        user1.setActive(false);
        System.out.println("\nChecking withdrawal in deactivated account");
        try {
            user1checking.makeWithdrawal(20000.0);
        } catch (DomainException e) {
            System.out.print(e.getMessage());
        }

        try {
            user1saving.makeWithdrawal(5001.0);
        } catch (DomainException e) {
            System.out.print(e.getMessage());
        }


    }
}
