package dev.rynwllngtn.agorasystem;

import dev.rynwllngtn.agorasystem.model.Account.Account;
import dev.rynwllngtn.agorasystem.model.Account.CheckingAccount;
import dev.rynwllngtn.agorasystem.model.Account.SavingAccount;
import dev.rynwllngtn.agorasystem.model.User;
import dev.rynwllngtn.agorasystem.model.exception.DomainException;

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

        tryWithdrawal(user1checking, 1.0);
        tryWithdrawal(user1saving, 1.0);

        //Trying withdrawal beyond limits
        user1checking.makeDeposit(100000.0);
        user1saving.makeDeposit(100000'.0);
        System.out.println("\nChecking withdrawal beyond limits");

        tryWithdrawal(user1checking, 20001.0);
        tryWithdrawal(user1saving, 5001.0);

        //Trying withdrawal in deactivated account
        user1.setActive(false);
        System.out.println("\nChecking withdrawal in deactivated account");

        tryWithdrawal(user1checking, 1.0);
        tryWithdrawal(user1saving, 1.0);
    }

    public static void tryWithdrawal(Account account, double amount) {
        try {
            account.makeWithdrawal(amount);
        } catch (DomainException e) {
            System.out.print(e.getMessage());
        }
    }
}
