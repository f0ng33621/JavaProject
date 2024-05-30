package repository.database;

import domain.Account;
import service.AccountRepository;

import java.util.Collection;

public class MongoAccountRepo implements AccountRepository {

    @Override
    public Account addAccount(String ownerId) {
        return null;
    }

    @Override
    public Account findAccount(String accountCode) {
        return null;
    }

    @Override
    public Account updateAccount(Account acc) {
        return null;
    }

    @Override
    public Collection<Account> allAccounts() {
        return null;
    }

    @Override
    public Collection<Account> allAccountsOwnedBy(String ownerId) {
        return null;
    }
}
