package oving7;

public class PassengerCar extends TrainCar {

    private int passengerCount;
    
    public PassengerCar(int x, int y) {
        super(x);
        super.isWeightValid(y);
        this.passengerCount = y;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int x) {
        super.isWeightValid(x);
        this.passengerCount = x;
    }

    @Override
    protected int getTotalWeight() {
        return super.getTotalWeight() + passengerCount * 80;
    }

}
