package oving7;

public abstract class AbstractAccount {
    
    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double x) {
        balance = x;
    }

    public void deposit(double x) {
        depositIsValid(x);
        balance += x;
        // balanceThisYear += x;
    }

    public void withdraw(double x) {
        withdrawalIsValid(x);
        balanceIsValid(balance - x);
        internalWithdraw(x);

    }

    abstract void internalWithdraw(double x);

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
