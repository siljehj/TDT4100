package oving7;

public class ForeldreSpar extends SavingsAccount {

    private int legalWithdrawals;

    public ForeldreSpar(double x, int y) {
        super(x);
        if (y < 0) {
            throw new IllegalArgumentException("Cannot be negative.");
        }
        this.legalWithdrawals = y;
    }

    public int getRemainingWithdrawals() {
        return legalWithdrawals - super.getWithdrawalCount();
    }

    @Override
    protected void withdrawalIsValid(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Cannot be negative.");
        }
        else if (super.getWithdrawalCount() == legalWithdrawals) {
            throw new IllegalStateException("No more withdrawals.");
        }
    }
    
}
