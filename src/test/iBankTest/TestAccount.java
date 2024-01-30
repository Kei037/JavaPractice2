package test.iBankTest;

import java.util.ArrayList;
import java.util.Scanner;

public class TestAccount {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<BankAccount> accountList = new ArrayList<>();

    public static void main(String[] args) {
        accountList.add(new SavingsAccount("1234", "tom", 10000, 0.05));
        accountList.add(new CheckingAccount("2345", "lim", 20000, 0.1));
        boolean run = true;
        while (run) {
            System.out.println("----------------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.조회 | 6.종료");
            System.out.println("----------------------------------------------------------");
            System.out.print("선택> ");

            int selectNo = scanner.nextInt();
            switch (selectNo) {
                case 1 -> createAccount();
                case 2 -> viewAccountList();
                case 3 -> deposit();
                case 4 -> withdraw();
                case 5 -> viewAccount();
                case 6 -> run = false;
            }

        }
        System.out.println("프로그램 종료");

    }

    private static void createAccount() {
        System.out.println("--------------");
        System.out.println("계좌생성");
        System.out.println("--------------");
        System.out.print("계좌종류: (1: 예금계좌, 2: 대출계좌): ");
        int accountType = scanner.nextInt();
        scanner.nextLine();
        if (accountType == 1) {
            System.out.print("계좌번호: ");
            String accountNumber = scanner.nextLine();

            System.out.print("계좌주: ");
            String accountHolder = scanner.nextLine();

            System.out.print("이자율: ");
            double interestRate = scanner.nextDouble();

            System.out.print("초기입금액: ");
            double balance = scanner.nextDouble();

            SavingsAccount savingsAccount = new SavingsAccount(accountNumber, accountHolder, balance, interestRate);
            accountList.add(savingsAccount);
            System.out.println("결과: 계좌가 생성되었습니다.");
        }
        if (accountType == 2) {
            System.out.print("계좌번호: ");
            String accountNumber = scanner.nextLine();

            System.out.print("계좌주: ");
            String accountHolder = scanner.nextLine();

            System.out.print("수수료율: ");
            double interestRate = scanner.nextDouble();

            System.out.print("초기대출액: ");
            double balance = scanner.nextDouble();

            CheckingAccount checkingAccount = new CheckingAccount(accountNumber, accountHolder, interestRate, balance);
            accountList.add(checkingAccount);
            System.out.println("결과: 계좌가 생성되었습니다.");
        }
    }

    private static void viewAccountList() {
        System.out.println("--------------");
        System.out.println("계좌목록");
        System.out.println("--------------");

        for (BankAccount bankAccount : accountList) {
            System.out.println(bankAccount);
        }

    }

    private static void deposit() {
        System.out.println("--------------");
        System.out.println("예금");
        System.out.println("--------------");
        System.out.print("계좌번호: ");
        String accountNumber = scanner.next();
        System.out.print("예금액: ");
        int depositMoney = scanner.nextInt();

        BankAccount bankAccount = findAccount(accountNumber);

        if (bankAccount == null) {
            System.out.println("결과: 계좌가 없습니다.");
        } else {
            if (0 >= depositMoney) {
                System.out.println("0원 이상만 입금가능합니다.");
            }else {
                bankAccount.deposit(accountNumber, depositMoney);
                System.out.println("예금이 성공되었습니다.");
            }
        }
    }

    private static void withdraw() {
        System.out.println("--------------");
        System.out.println("출금");
        System.out.println("--------------");
        System.out.print("계좌번호: ");
        String accountNumber = scanner.next();
        System.out.print("출금액: ");
        int depositMoney = scanner.nextInt();

        BankAccount bankAccount = findAccount(accountNumber);

        if (bankAccount == null) {
            System.out.println("결과: 계좌가 없습니다.");
        } else {
            if (bankAccount.getBalance() < depositMoney) {
                System.out.println("잔액보다 출금액이 커서 출금에 실패했습니다.");
            } else if (0 >= depositMoney) {
                System.out.println("0원 이상만 출금가능합니다.");
            } else {
                bankAccount.withdraw(accountNumber, depositMoney);
                System.out.println("출금이 성공되었습니다.");
            }
        }
    }

    private static void viewAccount() {
        System.out.println("--------------");
        System.out.println("조회");
        System.out.println("--------------");
        System.out.println();
        System.out.print("계좌번호: ");
        String accountNumber = scanner.next();
        BankAccount bankAccount = findAccount(accountNumber);

        if (bankAccount == null) {
            System.out.println("결과: 계좌가 없습니다.");
        }else {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                System.out.println(bankAccount);
            }
        }
    }

    private static BankAccount findAccount(String accountNumber) {
        BankAccount chackAccount = null;
        for (BankAccount bankAccount : accountList) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                chackAccount = bankAccount;
                break;
            }
        }
        return chackAccount;
    }

}
