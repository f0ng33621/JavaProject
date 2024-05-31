package repository.memory;


import domain.Account;
import service.AccountRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemAccountRepo implements AccountRepository {
    private static long AccountNumber = 0;
    private final Map<String, Account> repo = new HashMap<>();
    @Override
    public Account addAccount(String ownerId) {
        String accCode = "A" + ++AccountNumber;
        Account acc = new Account(accCode,ownerId,0.0);
        if(repo.putIfAbsent(accCode,acc) == null) return acc;
        return null;
    }

    @Override
    public Account findAccount(String accountCode) {
        return repo.get(accountCode);
    }

    @Override
    public Account updateAccount(Account acc) {
        try {
            repo.replace(acc.getCode(), acc);
        } catch (Exception e){
            return null;
        }
        return acc;
    }

    @Override
    public Collection<Account> allAccounts() {
        return repo.values();
    }

    @Override
    public Collection<Account> allAccountsOwnedBy(String ownerId) {
        return repo.values()
                .stream()
                .filter(a -> a.getOwnerId().equals(ownerId)).toList();
    }
}
