package ch_11.mvc.account_ex;

import java.util.Scanner;

public class AccountView {
    public static void printMenu() {
        System.out.println("============Menu============");
        System.out.println("1. 계좌개설");
        System.out.println("2. 입금");
        System.out.println("3. 출금");
        System.out.println("4. 잔액조회");
        System.out.println("5. 전체출력");
        System.out.println("6. 프로그램종료");
        System.out.println();
    }

    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        Scanner stdIn = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("선택:");
            int choice = stdIn.nextInt();
            switch (choice) {
                case 1:
                    manager.makeAccount();
                    break;
                case 2:
                    manager.deposit();
                    break;
                case 3:
                    manager.withdraw();
                    break;
                case 4:
                    System.out.println("계좌번호\t성명\t잔액");
                    manager.inquire();
                    break;
                case 5:
                    System.out.println("계좌번호\t성명\t잔액");
                    manager.display();
                    break;
                case 6:
                    System.out.println("종료합니다.");
                    manager.disConnect();
                    stdIn.close();
                    return;
                default:
                    System.out.println("잘못누르셧습니다.\n다시선택해주세요.");
                    break;
            }
        }

    }
}
