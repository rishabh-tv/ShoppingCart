public class Customer {

    private ShoppingCart shoppingCart;
    private CustomerEwallet eWallet;

    public Customer(CustomerEwallet eWallet){
        this.eWallet = eWallet;
        shoppingCart = new ShoppingCart();
    }

    public void addToCart(Products product){
        shoppingCart.addProduct(product);
    }

    public void removeProductFromCart(Products product){
        shoppingCart.removeProduct(product);
    }

    public double getWalletBalance(){
        return eWallet.getWalletBalance();
    }

    public void addWalletBalance(double amount){
        eWallet.addWalletBalance(amount);
    }

}