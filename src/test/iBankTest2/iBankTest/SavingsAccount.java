package test.iBankTest2.iBankTest;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        setBalance(getBalance() + (interestRate * amount) + amount);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        setBalance(getBalance() - amount);
    }

    @Override
    public String toString() {
        return "계좌 번호: " + getAccountNumber() + " / 계좌 소유주 이름: " +
                getAccountHolder() + " / 현재 잔액: " + getBalance() + " / 이자율: " + interestRate;
    }
}
