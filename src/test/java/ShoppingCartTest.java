import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShoppingCartTest {
    CustomerEwallet wallet ;
    @BeforeTest
    public void intialize(){
        wallet = new CustomerEwallet(500);
    }

    @Test
    public void verifyItemAvailablilty(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Customer customer = new Customer(wallet);
        Apple apple = new Apple("Apple", Apple.Categories.FreshApple,7,100);
        customer.addToCart(apple);
        boolean checkItemAvailabilty = shoppingCart.isItemAvailable(apple.getName());
        System.out.println("Item available ? "+checkItemAvailabilty);
        Assert.assertEquals(checkItemAvailabilty,false);


        Milk milk = new Milk("Milk", Milk.Categories.CowMilk,45,10);
        customer.addToCart(milk);
        boolean checkItemAvailabilty1 = shoppingCart.isItemAvailable(milk.getName());
        System.out.println("Item available ? "+checkItemAvailabilty1);
        Assert.assertEquals(checkItemAvailabilty1,false);

        Newspaper newspaper = new Newspaper("Newspaper", Newspaper.Categories.HindiNewspaper,5,5);
        customer.addToCart(newspaper);
        boolean checkItemAvailabilty2=shoppingCart.isItemAvailable(newspaper.getName());
        System.out.println("Item available ? "+checkItemAvailabilty2);
        Assert.assertEquals(checkItemAvailabilty2,false);

    }

    @Test
    public void verifySubtotalforEachItem(){

        ShoppingCart shoppingCart = new ShoppingCart();
        Customer customer = new Customer(wallet);
        Apple apple = new Apple("Apple", Apple.Categories.RedApple,3,100);
        customer.addToCart(apple);
        System.out.println(shoppingCart.getSubTotal(apple));

        Milk milk = new Milk("Milk", Milk.Categories.BuffaloMilk,45,10);
        customer.addToCart(milk);
        System.out.println(shoppingCart.getSubTotal(milk));

        Newspaper newspaper = new Newspaper("Newspaper", Newspaper.Categories.EnglishNewspaper,5,5);
        customer.addToCart(newspaper);
        System.out.println(shoppingCart.getSubTotal(newspaper));

    }

    @Test
    public void verifyTotalAmount(){

        ShoppingCart shoppingCart = new ShoppingCart();
        Customer customer = new Customer(wallet);

        Apple apple = new Apple("Apple", Apple.Categories.FreshApple,1,100);
        shoppingCart.addProduct(apple);
        customer.addToCart(apple);

        Milk milk = new Milk("Milk", Milk.Categories.BuffaloMilk,45,10);
        shoppingCart.addProduct(milk);
        customer.addToCart(milk);

        Newspaper newspaper = new Newspaper("Newspaper", Newspaper.Categories.EnglishNewspaper,
                5,5);
        shoppingCart.addProduct(newspaper);
        customer.addToCart(newspaper);

        double totalAmount = shoppingCart.getTotalAmount();
        System.out.println("Total Amount Payble is : "+totalAmount);
        Assert.assertEquals(totalAmount,575.0);

    }

    @Test
    public void verifyPaymentStatusViaEWallet(){

        Customer customer = new Customer(wallet);
        ShoppingCart shoppingCart = new ShoppingCart();
        Apple apple = new Apple("Apple", Apple.Categories.FreshApple,1,100);
        shoppingCart.addProduct(apple);
        customer.addToCart(apple);

        Milk milk = new Milk("Milk", Milk.Categories.CowMilk,45,10);
        shoppingCart.addProduct(milk);
        customer.addToCart(milk);

        Newspaper newspaper = new Newspaper("Newspaper", Newspaper.Categories.EnglishNewspaper,5,5);
        shoppingCart.addProduct(newspaper);
        customer.addToCart(newspaper);

        double totalAmount = shoppingCart.getTotalAmount();
        System.out.println("Total Amount Payble is : "+totalAmount);

        boolean paymentStatus = wallet.hasSufficientBalance(totalAmount);
        wallet.deductAmount(totalAmount);
        System.out.println("Payment Status from eWallet is : " + paymentStatus);

        Assert.assertEquals(paymentStatus,false);

    }

    @Test
    public void verifyAddWalletBalance(){
        Customer customer = new Customer(wallet);
        customer.addWalletBalance(500);
        System.out.println("Balance in the Wallet after loading the amount : "+ customer.getWalletBalance());
        Assert.assertEquals(1000,customer.getWalletBalance());
    }
}