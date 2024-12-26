package simplebank.v5;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class AccountManager {
    private ArrayList<Account> accounts = new ArrayList<Account>();

    private int countActiveAccounts() {
        int count = 0;
        for (Account account: accounts) 
            if (account.getStatus() == Account.Status.ACTIVE)
                count++;
        return count;
    }

    public Account openAccount(double initialBalance) {
        Account account = new Account(initialBalance);
        accounts.add(account);        
        return account;
    }

    public Account getAccount(String accountNumber) {
        for (Account account: accounts) 
            if (account.getAccountNumber().equals(accountNumber)) 
                return account;
        throw new NoSuchElementException("No such account number.");
    }

    public Account[] listAccounts() {
        Account[] results = new Account[countActiveAccounts()];

        int idx = 0;
        for (Account account: accounts)
            if (account.getStatus() == Account.Status.ACTIVE)
                results[idx++] = account;
        return results;
    }
}
