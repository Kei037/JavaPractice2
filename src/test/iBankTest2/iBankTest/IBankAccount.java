package test.iBankTest2.iBankTest;

public interface IBankAccount {
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
}
