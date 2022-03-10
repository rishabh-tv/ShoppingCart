public class CustomerEwallet implements Wallet{

    private double balance;

    public CustomerEwallet(double amount) {
        this.balance = amount;
    }

    @Override
    public double getWalletBalance() {
        return balance;
    }

    @Override
    public void addWalletBalance(double loadBalance) {
        balance += loadBalance;
    }

    @Override
    public void deductAmount(double amount) {
        if(balance>amount){
            this.balance -= amount;
        }
        else {
            System.out.println("InSuffucient balance!!! Please load you Wallet");
        }
    }

    public boolean hasSufficientBalance(double totalAmount){
        return getWalletBalance() > totalAmount;

    }
}