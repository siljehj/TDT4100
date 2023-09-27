package oving7;

public class SavingsAccount2 extends AbstractAccount {

    private int maxWithdrawals;
    private int withdrawalCount = 0;
    private double fee;

    public SavingsAccount2(int x, double y) {
        numIsValid(x);
        numIsValid(y);
        maxWithdrawals = x;
        fee = y;
    }

    @Override
    void internalWithdraw(double x) {
        if (withdrawalCount == maxWithdrawals) {
            balanceIsValid(super.getBalance() - x - fee);
            super.setBalance(super.getBalance() - x - fee);
            return;
        }
        super.setBalance(super.getBalance() - x);
        withdrawalCount ++;

    }

    private void numIsValid(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Must be over 0.");
        }
    }


}
