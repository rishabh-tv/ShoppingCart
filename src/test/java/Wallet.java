public interface Wallet {

    double getWalletBalance();
    void addWalletBalance(double loadBalance);
    void deductAmount(double amount);

}