public class Milk implements Products{
    private int quantity;
    private double amount;
    private String  name;
    private Categories type;


    public Milk(String name ,Categories type, int quantity, double amount) {
        this.name = name;
        this.quantity = quantity;
        this.amount = amount;
        this.type = type;
    }

    public enum Categories{
        CowMilk,
        BuffaloMilk
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