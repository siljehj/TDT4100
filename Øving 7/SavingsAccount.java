package oving7;

public class SavingsAccount implements Account {

    private int balanceThisYear;
    private int balance;
    private double interestRate;
    private int withdrawalCount;

    public SavingsAccount(double x) {
        if (!numIsValid(x)) {
            throw new IllegalArgumentException("Cannot be negative.");
        }
        else if (x > 1) {
            throw new IllegalArgumentException("Must be between 0 and 1.");
        }
        this.interestRate = x;
        this.balance = 0;
        this.balanceThisYear = 0;
        this.withdrawalCount = 0;
    }

    public double getBalance() {
        return balance;
    }

    public double getBalanceThisYear() {
        return balanceThisYear;
    }

    public int getWithdrawalCount() {
        return withdrawalCount;
    }

    public void deposit(double x) {
        depositIsValid(x);
        balance += x;
        balanceThisYear += x;
    }

    public void withdraw(double x) {
        withdrawalIsValid(x);
        balanceIsValid(balance - x);
        balance -= x;
        withdrawalCount ++;
    }

    public void endYearUpdate() {
        balance += balance * interestRate;
        balanceThisYear = 0;
        withdrawalCount = 0;
    }

    private boolean numIsValid(double x) {
        return x >= 0;
    }

    protected void depositIsValid(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot be negative.");
        }
    }

    protected void withdrawalIsValid(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Cannot be negative.");
        }
    }

    protected void balanceIsValid(double x) {
        if (x < 0) {
            throw new IllegalStateException("Balance cannot be negative.");
        }
    }

    
    

}
