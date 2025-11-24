public class InventoryItem {
    private String name;
    private int quantity;
    private double price;

    public InventoryItem(String name, int quantity, double price) {
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity cannot be negative");
        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative");
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void addStock(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive");
        quantity += amount;
    }

    public void sell(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive");
        if (amount > quantity)
            throw new IllegalStateException("Not enough stock");
        quantity -= amount;
    }

    public double totalValue() {
        return quantity * price;
    }

    public int getQuantity() {
        return quantity;
    }

}