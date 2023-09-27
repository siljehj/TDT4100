package oving7;

import java.util.ArrayList;
import java.util.Collection;

public class Train {

    private Collection<TrainCar> trainCars = new ArrayList<TrainCar>();

    public Train() {

    }

    public void addTrainCar(TrainCar t) {
        if (contains(t)) {
            throw new IllegalArgumentException("Traincar already in train.");
        }
        trainCars.add(t);
    }

    public boolean contains(TrainCar t) {
        return trainCars.contains(t);
    }

    public int getTotalWeight() {
        return trainCars.stream().mapToInt(TrainCar::getTotalWeight).sum();
    }

    public int getPassengerCount() {
        // return trainCars.stream().filter(t -> t instanceof PassengerCar).mapToInt(p -> getPassengerCount()).sum();
        return trainCars.stream().filter(PassengerCar.class::isInstance).mapToInt(p -> (p.getTotalWeight() - p.getDeadWeigth()) / 80).sum(); //(PassengerCar::getPassengerCount).sum();
    }

    public int getCargoWeight() {
        return trainCars.stream().filter(CargoCar.class::isInstance).mapToInt(c -> c.getTotalWeight() - c.getDeadWeigth()).sum();
    }

    @Override
    public String toString() {
        return trainCars.stream().map(TrainCar::toString).reduce("\n", String::concat);
    }

    public static void main(String[] args) {
        TrainCar t = new PassengerCar(1000, 5);
        TrainCar s = new PassengerCar(1000, 8);
        Train train = new Train();
        train.addTrainCar(t);
        train.addTrainCar(s);
        System.out.println(train.getTotalWeight());
    }




}
