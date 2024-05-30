package domain;

public class Transaction {
    private final String type;
    private final double amount;
    private final double postBalance;

    public Transaction(String type, double amount, double postBalance) {
        this.type = type;
        this.amount = amount;
        this.postBalance = postBalance;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getPostBalance() {
        return postBalance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", postBalance=" + postBalance +
                '}';
    }
}
