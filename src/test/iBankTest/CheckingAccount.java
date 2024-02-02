package test.iBankTest;

public class CheckingAccount extends BankAccount {
    private double chargeRate;

    public CheckingAccount(String accountNumber, String accountHolder, double balance, double chargeRate) {
        super(accountNumber, accountHolder, balance);
        this.chargeRate = chargeRate;
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        setBalance(getBalance() - (amount * chargeRate) - amount);
    }

    @Override
    public String toString() {
        return "계좌 번호: " + getAccountNumber() + " / 계좌 소유주 이름: " +
                getAccountHolder() + " / 현재 잔액: " + getBalance() + " / 이자율: " + chargeRate;
    }
}
