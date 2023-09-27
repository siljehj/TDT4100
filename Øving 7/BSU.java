package oving7;

public class BSU extends SavingsAccount {

    private double maxDeposit;
    
    public BSU(double x, double y) {
        super(x);
        this.maxDeposit = y;
    }

    public double getTaxDeduction() {
        return super.getBalanceThisYear() * 0.2;
    }

    @Override
    protected void depositIsValid(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Must be over 0.");
        } 
        else if (super.getBalanceThisYear() + x > maxDeposit) {
            throw new IllegalStateException("Too much lol.");
        }
    }

    @Override 
    protected void withdrawalIsValid(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Cannot be negative.");
        }
        else if (x > super.getBalanceThisYear()) {
            throw new IllegalStateException("Cannot withdraw this much.");
        }
    }

    // @Override
    // protected void balanceIsValid(double x) {
    //     if (x < 0) {
    //         throw new IllegalStateException("Balance cannot be negative.");
    //     }
    // }

}
