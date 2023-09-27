package oving6.observable;

public class StockListenerDifference {

    private StockListener listener;
    private double difference;
    private double lastPrice;

    public StockListenerDifference(StockListener s, double d) {
        this.listener = s;
        this.difference = d;
    }

    public void setLastPrice(double x) {
        this.lastPrice = x;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public StockListener getListener() {
        return listener;
    }

    public double getDifference() {
        return difference;
    }
    
}
