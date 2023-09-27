package oving7;

public class CreditAccount extends AbstractAccount {
    
    private double creditLine;

    public CreditAccount(double x) {
        creditLineIsValid(x);
        creditLine = x;
    }

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        creditLineIsValid(creditLine);
        this.creditLine = creditLine;
    }

    @Override
    void internalWithdraw(double x) {
        super.setBalance(super.getBalance() - x);
    }

    @Override
    protected void balanceIsValid(double x) {
        if (x + creditLine < 0) {
            throw new IllegalStateException("Cannot withdraw over credit line.");
        }
    }

    private void creditLineIsValid(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Must be 0 or more.");
        }
        else if (super.getBalance() + x < 0) {
            throw new IllegalStateException("Invalid credit line.");
        }
    }


}
