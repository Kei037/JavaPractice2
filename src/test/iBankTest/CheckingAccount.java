package test.iBankTest;

public class CheckingAccount extends BankAccount {
    private double chargeRate;

    public CheckingAccount(String accountNumber, String accountHolder, double balance, double chargeRate) {
        super(accountNumber, accountHolder, balance);
        this.chargeRate = chargeRate;
    }

    public double getChargeRate() {
        return chargeRate;
    }

    public void setChargeRate(double chargeRate) {
        this.chargeRate = chargeRate;
    }

    @Override
    public void deposit(String accountNumber, double amount) {

    }

    @Override
    public void withdraw(String accountNumber, double amount) {

    }

}
