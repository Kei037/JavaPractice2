package test.iBankTest2;

public class CheckingAccount extends BankAccount {
    private double chargeRate;

    public CheckingAccount(String accountNumber, String accountHolder, double balance, double chargeRate) {
        super(accountNumber, accountHolder, balance);
        this.chargeRate = chargeRate;
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        System.out.println("체크어카운트 디포짓");
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        System.out.println("이자율" + chargeRate);
        setBalance(getBalance() - amount - (amount * chargeRate));
    }

    @Override
    public String toString() {
        return super.toString() + " / 이자율: " + chargeRate;
    }
}
