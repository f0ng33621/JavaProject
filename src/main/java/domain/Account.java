package domain;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String code;
    private final String ownerId;
    private String password;
    private double balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String code, String ownerId,String password,double balance) {
        this.code = code;
        this.ownerId = ownerId;
        this.password = password;
        this.balance = balance;
    }

    public String getCode() {
        return code;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "code='" + code + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", balance=" + balance +
                '}';
    }

    public boolean deposit(double amount) {
        if (amount <= 0.0) return false;
        balance += amount;
        transactions.add(new Transaction("deposit", amount, balance));
        return true;
    }


    public boolean withdraw(double amount) {
        if (amount > balance || amount <= 0.0) return false;
        balance -= amount;
        transactions.add(new Transaction("withdraw", amount, balance));
        return true;
    }
    public boolean transfer(Account ac,double amount){
        if (amount > balance || amount <= 0.0) return false;
        balance -= amount;
        ac.balance += amount;
        transactions.add(new Transaction("transfer to " + ac.getCode(), amount, balance));
        ac.transactions.add(new Transaction("transfer from " + this.getCode(), amount, ac.getBalance()));
        return true;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}