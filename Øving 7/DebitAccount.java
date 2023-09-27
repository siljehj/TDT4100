package oving7;

public class DebitAccount extends AbstractAccount {

    public DebitAccount() {
    }
    
    @Override
    protected void internalWithdraw(double x) {
       super.setBalance(super.getBalance() - x);
    }
    
}
