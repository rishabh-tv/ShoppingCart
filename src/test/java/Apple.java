public class Apple implements Products {
    private int quantity;
    private double amount;
    private String name;
    private Categories type;


    public Apple(String name, Categories type, int quantity, double amount) {
        this.name = name;
        this.quantity = quantity;
        this.amount = amount;
        this.type = type;
    }


    public enum Categories {
        FreshApple,
        RedApple
    }

    @Override
    public int getQuantity() {
        return quantity;
    }


    @Override
    public double getPrice() {
        return amount;
    }

    @Override
    public String getName() {
        return name;
    }
}
