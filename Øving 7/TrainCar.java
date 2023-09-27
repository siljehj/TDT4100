package oving7;

public class TrainCar {

    private int deadWeight;
    private int totalWeight;

    public TrainCar(int n) {
        isWeightValid(n);
        this.deadWeight = n;
        this.totalWeight = n;
    }

    public int getDeadWeigth() {
        return deadWeight;
    }

    protected int getTotalWeight() {
        return totalWeight;
    }

    public void setDeadWeight(int x) {
        isWeightValid(x);
        // this.totalWeight += (x - deadWeight);
        this.totalWeight = x;
        this.deadWeight = x;
    }

    protected void isWeightValid(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot be negative.");
        }
    }

    @Override
    public String toString() {
        return "Dead weight: " + deadWeight + "\nTotal weight: " + totalWeight + "\n";
    }

    public static void main(String[] args) {
        TrainCar t = new TrainCar(1500);
        System.out.println(t);
        t.setDeadWeight(1900);
        System.out.println(t);

        PassengerCar s = new PassengerCar(5000, 2);
        s.getPassengerCount();
    }
}
