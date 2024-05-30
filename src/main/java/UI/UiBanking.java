package UI;

import domain.Customer;
import repository.database.MongoAccountRepo;
import repository.database.MongoCustomerRepo;
import repository.memory.MemAccountRepo;
import repository.memory.MemCustomerRepo;
import service.BankingService;
import domain.Account;
import java.util.Scanner;
import domain.Transaction;

public class UiBanking {
    private final BankingService service;

    public UiBanking(boolean useDatabase) {
        if (!useDatabase){
            service = new BankingService(new MemAccountRepo(),new MemCustomerRepo());
        } else {
            service = new BankingService(new MongoAccountRepo(), new MongoCustomerRepo());
        }
    }
    public void start(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to Banking Service");
            System.out.println("1. Register Customer");
            System.out.println("2. Rename Customer");
            System.out.println("3. Add Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Transfer");
            System.out.println("7. View Account Transactions");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    Customer customer = service.registerCustomer(name);
                    if (customer != null) {
                        System.out.println("Customer registered with ID: " + customer.getId());
                    } else {
                        System.out.println("Failed to register customer.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter customer ID: ");
                    String customerId = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    Customer customer = service.renameCustomer(customerId, newName);
                    if (customer != null) {
                        System.out.println("Customer renamed to: " + customer.getName());
                    } else {
                        System.out.println("Failed to rename customer.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter owner ID: ");
                    String ownerId = scanner.nextLine();
                    Account account = service.addAccount(ownerId);
                    if (account != null) {
                        System.out.println("Account created with code: " + account.getCode());
                    } else {
                        System.out.println("Failed to create account.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter account code: ");
                    String accountCode = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    Account account = service.deposit(accountCode, amount);
                    if (account != null) {
                        System.out.println("Deposited successfully. New balance: " + account.getBalance());
                    } else {
                        System.out.println("Failed to deposit.");
                    }
                }
                case 5 -> {
                    System.out.print("Enter account code: ");
                    String accountCode = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    Account account = service.withdraw(accountCode, amount);
                    if (account != null) {
                        System.out.println("Withdrew successfully. New balance: " + account.getBalance());
                    } else {
                        System.out.println("Failed to withdraw.");
                    }
                }
                case 6 -> {
                    System.out.print("Enter source account code: ");
                    String fromAccountCode = scanner.nextLine();
                    System.out.print("Enter destination account code: ");
                    String toAccountCode = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    boolean success = service.transfer(fromAccountCode,toAccountCode,amount);
                    if (success) {
                        System.out.println("Transferred successfully.");
                    } else {
                        System.out.println("Failed to transfer.");
                    }
                }
                case 7 -> {
                    System.out.print("Enter account code: ");
                    String accountCode = scanner.nextLine();
                    Account account = service.findAccount(accountCode);
                    if (account != null) {
                        System.out.println("Transactions for account " + accountCode + ":");
                        for (Transaction t : account.getTransactions()) {
                            System.out.println(t);
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                }
                case 8 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();





    }
}
