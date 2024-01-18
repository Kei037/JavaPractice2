package ch_02.account;

import java.util.Scanner;

public class TestAccount {
    private static final int max = 3;
    private static final Account[] accountArray = new Account[max];
    private static final Scanner scanner = new Scanner(System.in);
    private static int idx = 0;

    public static void main(String[] args) {
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
        if (idx >= max) {
            System.out.println("생성 가능한 계좌의 범위를 초과했습니다.");
        }else {
            System.out.println("--------------");
            System.out.println("계좌생성");
            System.out.println("--------------");

            scanner.nextLine();
            System.out.print("계좌번호: ");
            String ano = scanner.nextLine();

            System.out.print("계좌주: ");
            String owner = scanner.nextLine();

            System.out.print("초기입금액: ");
            int balance = scanner.nextInt();

            Account newAccount = new Account(ano, owner, balance);
            accountArray[idx] = newAccount;
            idx++;
            System.out.println("결과: 계좌가 생성되었습니다.");
        }
    }

    private static void viewAccountList() {
        System.out.println("--------------");
        System.out.println("계좌목록");
        System.out.println("--------------");

        for (int i = 0; i < idx; i++) {
            Account account = accountArray[i];
            if (account != null) {
                System.out.print(account.getAno() + " " + account.getOwner() +
                        " " + account.getBalance());
                System.out.println();
            } else {
                break;
            }

        }
    }
    private static void deposit() {
        System.out.println("--------------");
        System.out.println("예금");
        System.out.println("--------------");
        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("예금액: ");
        int money = scanner.nextInt();
        Account account = findAccount(ano);

        if (account == null) {
            System.out.println("결과: 계좌가 없습니다.");
        } else {
            if (0 >= money) {
                System.out.println("0원 이상만 입금가능합니다.");
            }else {
                account.setBalance(account.getBalance() + money);
                System.out.println("예금이 성공되었습니다.");
            }
        }
    }

    private static void withdraw() {
        System.out.println("--------------");
        System.out.println("출금");
        System.out.println("--------------");
        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("출금액: ");
        int money = scanner.nextInt();
        Account account = findAccount(ano);

        if (account == null) {
            System.out.println("결과: 계좌가 없습니다.");
        } else {
            if (account.getBalance() < money) {
                System.out.println("잔액보다 출금액이 커서 출금에 실패했습니다.");
            } else if (0 >= money) {
                System.out.println("0원 이상만 출금가능합니다.");
            } else {
                account.setBalance(account.getBalance() - money);
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
        String ano = scanner.next();

        Account account = findAccount(ano);

        if (account == null) {
            System.out.println("결과: 계좌가 없습니다.");
        } else {
            if (account.getAno().equals(ano)) {
                System.out.print(account.getAno() + " " + account.getOwner() +
                        " " + account.getBalance());
                System.out.println();
            } else {
                System.out.println("테스트 코드 : " + account.getAno() + ", " + ano);
                System.out.println("결과: 계좌가 없습니다.");
            }
        }
    }

    private static Account findAccount(String ano) {
        Account account = null;
        for (int i = 0; i < idx; i++) {
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
