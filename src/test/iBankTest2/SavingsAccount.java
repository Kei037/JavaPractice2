package test.iBankTest2;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        System.out.println("세이빙어카운트 디포짓");
        setBalance(getBalance() + (interestRate * amount) + amount);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        setBalance(getBalance() - amount);
    }

    @Override
    public String toString() {
        return super.toString() + " / 이자율: " + interestRate;
    }
}
