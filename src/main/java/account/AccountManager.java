package account;

import bankbranch.Bank;
import exceptions.BalanceCannotBeNegativeException;
import exceptions.TransferCannotBeNegativeException;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    public static List<Account> AVAILABLE_USER_ACCOUNTS = new ArrayList<>();

    public Account createUserAccount(String accountOwnerBank, double balance, String accountNumber, Bank bank) throws BalanceCannotBeNegativeException {
        var user = new Account(accountOwnerBank, balance, accountNumber, bank);
        AVAILABLE_USER_ACCOUNTS.add(user);
        return user;
    }

    public void depositMoneyToAccount(Account user, double depositedAmount) {
        if (depositedAmount > 0) {
            changeBalance(user, depositedAmount);
        } else {
            System.out.println("Deposited amount is zero or less than zero");
        }
    }

    private void changeBalance(Account userAccount, double depositedAmount) {
        double balance = userAccount.getBalance();
        userAccount.setBalance(depositedAmount + balance);
        String message = "Amount deposited " + depositedAmount + "balance " + userAccount.getBalance();
    }

    public void withdrawMoneyFromAccount(Account userAccount, double withdrawAmount) {
        if (withdrawAmount > 0) {
            double balance = userAccount.getBalance();
            userAccount.setBalance(balance - withdrawAmount);
            String message = "Amount withdraw " + withdrawAmount + "balance " + userAccount.getBalance();
        } else {
            System.out.println("Deposited amount is zero or less than zero");
        }
    }

}





