package ch_02.accountpg;

import java.util.Scanner;

public class TestAccount {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Account[] accountArray = new Account[100];

    public static void main(String[] args) {
        accountArray[0] = new Account("123", "홍길동", 1000);
        accountArray[1] = new Account("321", "김자바", 2000);
        accountArray[2] = new Account("414", "박디비", 3000);
        boolean run = true;
        while (run) {
            System.out.println("------------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("------------------------------------------------------");
            System.out.print("선택> ");

            int selectNo = scanner.nextInt();

            if (selectNo == 1) {
                createAccount();
            } else if (selectNo == 2) {
                accountList();
            } else if (selectNo == 3) {
                deposit();
            } else if (selectNo == 4) {
                withdraw();
            } else if (selectNo == 5) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");

    }

    private static void createAccount() {
        System.out.println("-------------");
        System.out.println("계좌생성");
        System.out.println("-------------");

        scanner.nextLine();
        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();

        System.out.print("계좌주: ");
        String owner = scanner.nextLine();

        System.out.print("초기입금액: ");
        int balance = scanner.nextInt();

        Account newAccount = new Account(ano, owner, balance);
        // newAccount는 지역 변수라서 메서드가 종료되면 사라짐. 그래서 멤버 변수인 accountArray에 저장
        for (int i = 0; i < accountArray.length; i++) {
            if (accountArray[i] == null) {
                accountArray[i] = newAccount;
                System.out.println("결과 : 계좌가 생성되었습니다.");
               // System.out.println(accountArray[i].toString());  계좌생성 테스트코드
                break;
            }
        }

    }
    private static void accountList() {
        System.out.println("-------------");
        System.out.println("계좌목록");
        System.out.println("-------------");

        for (int i = 0; i < accountArray.length; i++) {
            Account account = accountArray[i];
            if (account != null) {
                System.out.print(account.getAno());
                System.out.print("    ");
                System.out.print(account.getOwner());
                System.out.print("    ");
                System.out.print(account.getBalance());
                System.out.println();
            } else {
                break;
            }

        }
    }
    private static void deposit() {
        System.out.println("-------------");
        System.out.println("예금");
        System.out.println("-------------");
        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("예금액: ");
        int money = scanner.nextInt();
        Account account = findAccount(ano);

        if (account == null) {
            System.out.println("틀린 계좌번호입니다.");
        } else {
            account.setBalance(account.getBalance() + money);
            System.out.println("예금이 성공되었습니다.");
        }

        /*
        for (int i = 0; i < accountArray.length; i++) {
            Account account = accountArray[i];
            if (account != null) {
                if (ano.equals(account.getAno())) {
                    account.setBalance(account.getBalance() + money);
                    System.out.print("예금이 성공되었습니다.");
                }
            } else {
                break;
            }
        }
         */

    }
    private static void withdraw() {
        System.out.println("-------------");
        System.out.println("출금");
        System.out.println("-------------");
        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("출금액: ");
        int money = scanner.nextInt();
        Account account = findAccount(ano);

        if (account == null) {
            System.out.println("틀린 계좌번호입니다.");
        } else {
            account.setBalance(account.getBalance() - money);
            System.out.println("출금이 성공되었습니다.");
        }
        /*
        for (int i = 0; i < accountArray.length; i++) {
            Account account = accountArray[i];
            if (account != null) {
                if (ano.equals(account.getAno())) {
                    account.setBalance(account.getBalance() - money);
                    System.out.print("출금이 성공되었습니다.");
                }
            } else {
                break;
            }
        }
         */
    }

    private static Account findAccount(String ano) {
        Account account = null;
        for (int i = 0; i < accountArray.length; i++) {
            if (accountArray[i] != null) {
                if (accountArray[i].getAno().equals(ano)) {
                    account = accountArray[i];
                    break;
                }
            } else {
                break;
            }
        }
        return account;
    }
}
