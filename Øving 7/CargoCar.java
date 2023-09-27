package oving7;

public class CargoCar extends TrainCar {

    private int cargoWeight;

    public CargoCar(int x, int y) {
        super(x);
        super.isWeightValid(y);
        this.cargoWeight = y;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int x) {
        super.isWeightValid(x);
        this.cargoWeight = x;
    }
 

    @Override
    protected int getTotalWeight() {
        return super.getTotalWeight() + cargoWeight;
    }

    
}
