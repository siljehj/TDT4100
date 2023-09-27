package oving4;

import java.util.ArrayList;

public class Merchant {

    private double cash;
    private ArrayList<Item> inventory = new ArrayList<>();
    // private String name;

    public Merchant(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Starting price cannot be negative.");
        }
        this.cash = x;
    }

    public double getBalance() {
        return cash;
    }

    public void changeBalance(double money) {
        cash += money;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void obtainItem(Item item) {
        if (inventory.contains(item)) {
            throw new IllegalArgumentException("Item already in inventory.");
        }
        inventory.add(item);
    }

    public void removeItem(Item item) {
        if (!inventory.contains(item)) {
            throw new IllegalArgumentException("Item not in inventory.");
        }
        inventory.remove(item);
    }

    public void sellItem(Item item, Merchant merchant) {
        validateSale(item, merchant);
        merchant.obtainItem(item);
        this.removeItem(item);
        changeBalance(item.getPrice());
        merchant.changeBalance(-item.getPrice());
        item.changeOwner(merchant);
    }

    public void itemSale(double num, Item item) {
        validateNum(num);
        if (!inventory.contains(item)) {
            throw new IllegalArgumentException("Item not in inventory.");
        }
        item.setPrice(item.getPrice() * num);
    }

    public void inventorySale(double num) {
        for (Item i : inventory) {
            itemSale(num, i);
        }

    }
    

    private void validateNum(double num) {
        if (num <= 0 || num >= 1) {
            throw new IllegalArgumentException("Must be between 0 and 1.");
        }
    }

    private void validateSale(Item item, Merchant merchant) {
        if (merchant.getBalance() < item.getPrice() || !this.inventory.contains(item) || this == merchant) {
            throw new IllegalStateException("Cannot make sale.");
        }
    }

    public String toString() {
        System.out.println("Balance: " + cash);
        System.out.println("Items: ");
        for (Item i : inventory) {
            System.out.println("- " + i);
        }
        return "";
    }

    public static void main(String[] args) {
        Merchant m = new Merchant(9.2);
        System.out.println(m);
    }

}
