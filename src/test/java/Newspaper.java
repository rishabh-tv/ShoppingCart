public class Newspaper implements Products{

    private String name;
    private double price;
    private Categories category;
    private int quantity;


    public Newspaper(String name , Categories category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public enum Categories{
        EnglishNewspaper,
        HindiNewspaper
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }


}