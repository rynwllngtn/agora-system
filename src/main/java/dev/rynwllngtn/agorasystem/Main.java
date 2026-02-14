package dev.rynwllngtn.agorasystem;

import dev.rynwllngtn.agorasystem.model.Account.CheckingAccount;
import dev.rynwllngtn.agorasystem.model.Account.SavingAccount;
import dev.rynwllngtn.agorasystem.model.User;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(
                "User",
                "20000101",
                "user1email@domain.com",
                "0001112223",
                "1234567890");

        System.out.println(user1.toString());

        //Creating Bank accounts and making depositing in both
        CheckingAccount user1checking = new CheckingAccount(user1);
        SavingAccount user1saving = new SavingAccount(user1);
        user1checking.makeDeposit(25000.0);
        user1saving.makeDeposit(25000.0);

        //Trying unique account type functions
        user1checking.makeMonthlyPayment();
        user1saving.applyMonthlyInterest();
        System.out.println("\nChecking unique account type functions");
        System.out.println(user1checking.toString());
        System.out.println(user1saving.toString());

        //Trying withdrawal beyond limits
        user1checking.makeWithdrawal(20000.0);
        user1saving.makeWithdrawal(5001.0);
        System.out.println("\nChecking withdrawal beyond limits");
        System.out.println(user1checking.toString());
        System.out.println(user1saving.toString());

        //Trying withdrawal within limits
        user1checking.makeWithdrawal(19000.0);
        user1saving.makeWithdrawal(4000.0);
        System.out.println("\nChecking withdrawal within limits");
        System.out.println(user1checking.toString());
        System.out.println(user1saving.toString());

    }
}
