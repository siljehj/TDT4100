package oving4;

public class Item {

    private String name;
    private String type;
    private double price;
    private Merchant owner;

    public Item(String name, String type, double num) {
        validateNum(num);
        validateType(type);
        validateName(name);
        this.name = name;
        this.type = type;
        this.price = num;
    }

    public Merchant getOwner() {
        return owner;
    }

    public void changeOwner(Merchant merchant) {
        this.owner = merchant;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double x) {
        validateNum(x);
        this.price = x;
    }

    private void validateNum(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot be negative.");
        }
    }

    private void validateType(String type) {
        if (!type.toLowerCase().equals("weapon") && !type.toLowerCase().equals("armour")
                && !type.toLowerCase().equals("potion") && !type.toLowerCase().equals("valuable")) {
            throw new IllegalArgumentException("Invalid type.");
        }
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
    }

    public String toString() {
        return "Item: " + name + "\tType: " + type + "\tPrice: " + price; // + getOwner();
    }

    public static void main(String[] args) {
        Item item1 = new Item("Sunveil Katana", "Weapon", 500);
        Item item2 = new Item("Carian greaves", "Armour", 100);
        Merchant merchant1 = new Merchant(100);
        Merchant merchant2 = new Merchant(1000);
        merchant2.obtainItem(item1);
        merchant2.obtainItem(item2);
        System.out.println(merchant1);
        System.out.println(merchant2);
        merchant2.sellItem(item2, merchant1);
        System.out.println(merchant1);
        System.out.println(merchant2);
        System.out.println(item2.getOwner());
    }

}
