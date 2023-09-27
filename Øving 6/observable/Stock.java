package oving6.observable;

import java.util.ArrayList;

public class Stock {

    private String ticker;
    private double price;
    private ArrayList<StockListener> listeners = new ArrayList<StockListener>();
    
    public Stock(String s, double d) {
        validatePrice(d);
        this.ticker = s;
        this.price = d;
    }

    public void setPrice(double x) {
        validatePrice(x);
        for (StockListener s : listeners) {
            s.stockPriceChanged(this, price, x);
        }
        this.price = x;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return price;
    }

    public void addStockListener(StockListener listener) {
        if (!listeners.add(listener)) {
            throw new IllegalArgumentException("Already in list.");
        }
    }

    public void removeStockListener(StockListener listener) {
        if (!listeners.remove(listener)) {
            throw new IllegalArgumentException("Not in list.");
        }
    }

    private void validatePrice(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Cannot be 0 or negative.");
        }
    }

}
