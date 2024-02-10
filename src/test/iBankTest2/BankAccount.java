package test.iBankTest2;

public class BankAccount implements IBankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(String accountNumber, double amount) {}

    @Override
    public void withdraw(String accountNumber, double amount) {}

    @Override
    public String toString() {
        return "계좌 번호: " + getAccountNumber() + " / 계좌 소유주 이름: " +
                getAccountHolder() + " / 현재 잔액: " + getBalance();
    }

}
