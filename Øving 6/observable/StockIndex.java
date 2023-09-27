package oving6.observable;

import java.util.ArrayList;

public class StockIndex implements StockListener {

    private String name;
    private double index = 0;
    private ArrayList<Stock> stocks = new ArrayList<Stock>();

    public StockIndex(String s, Stock... stocks) {
        this.name = s;
        if (stocks != null) {
            for (Stock x : stocks) {
                this.stocks.add(x);
                this.index += x.getPrice();
                x.addStockListener(this);
            }
        }
    }

    public void addStock(Stock stock) {
        if (!stocks.contains(stock)) {
            stocks.add(stock);
            index += stock.getPrice();
        }
    }

    public void removeStock(Stock stock) {
        if (stocks.remove(stock)) {
            index -= stock.getPrice();
        }
    }

    public double getIndex() {
        return index;
    }

    public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
        if (stocks.contains(stock)) {
            index += (newValue - oldValue);
        }
    }

}
