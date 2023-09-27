package oving6.observable;

import java.util.ArrayList;

public class SmartStock {

    private Stock stock;
    private String ticker;
    private double price;
    private ArrayList<StockListener> listeners = new ArrayList<StockListener>();
    private ArrayList<StockListenerInterval> listenersWithInterval = new ArrayList<StockListenerInterval>();
    private ArrayList<StockListenerDifference> listenersWithDifference = new ArrayList<StockListenerDifference>();

    public SmartStock(String s, double d) {
        validatePrice(d);
        Stock t = new Stock(s, d);
        this.ticker = s;
        this.price = d;
        this.stock = t;
    }

    public void setPrice(double x) {
        validatePrice(x);
        for (StockListener s : listeners) {
            s.stockPriceChanged(this.stock, price, x);
        }
        for (StockListenerInterval t : listenersWithInterval) {
            if (intervalIsValid(t, x)) {
                t.getListener().stockPriceChanged(this.stock, price, x);
            }
        }
        for (StockListenerDifference u : listenersWithDifference) {
            if (differenceIsValid(u, x)) {
                u.getListener().stockPriceChanged(this.stock, u.getLastPrice(), x);
                u.setLastPrice(x);
            }
        }
        this.price = x;
        this.stock.setPrice(x);
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

    public void addStockListener(StockListener listener, double min, double max) {
        StockListenerInterval s = new StockListenerInterval(listener, min, max);
        if (!listenersWithInterval.add(s)) {
            throw new IllegalArgumentException("Already in list.");
        }
    }

    public void addStockListener(StockListener listener, double difference) {
        StockListenerDifference s = new StockListenerDifference(listener, difference);
        s.setLastPrice(price);
        if (!listenersWithDifference.add(s)) {
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

    private boolean intervalIsValid(StockListenerInterval s, double x) {
        if (x < s.getMin() || x > s.getMax()) {
            return true;
        }
        return false;
    }

    private boolean differenceIsValid(StockListenerDifference s, double x) {
        if (Math.abs(x - s.getLastPrice()) > s.getDifference()) {
            return true;
        }
        return false;
    }
}


