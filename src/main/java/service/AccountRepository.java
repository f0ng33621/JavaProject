package service;

import domain.Account;

import java.util.Collection;

public interface AccountRepository {
    public Account addAccount(String ownerId);
    public Account findAccount(String accountCode);
    public Account updateAccount(Account acc);
    public Collection<Account> allAccounts();
    public Collection<Account> allAccountsOwnedBy(String ownerId);


}
