package oving6.observable;

public class StockListenerInterval {
    
    private StockListener listener;
    private double minPrice;
    private double maxPrice;

    public StockListenerInterval(StockListener listener, double min, double max) {
        this.listener = listener;
        this.minPrice = min;
        this.maxPrice = max;
    }

    public StockListener getListener() {
        return listener;
    }

    public double getMin() {
        return minPrice;
    }

    public double getMax() {
        return maxPrice;
    }


}
