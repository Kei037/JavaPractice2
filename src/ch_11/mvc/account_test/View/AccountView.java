package ch_11.mvc.account_test.View;

import ch_11.mvc.account_test.Controller.AccountManager;

import java.util.Scanner;

public class AccountView {
    public static void printMenu() {
        System.out.println("============Menu============");
        System.out.println("1. 회원등록");
        System.out.println("2. 계좌개설");
        System.out.println("3. 입금");
        System.out.println("4. 출금");
        System.out.println("5. 잔액 및 거래 내역 조회");
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
                    manager.addMember();
                    break;
                case 2:
                    manager.addAccount();
                    break;
                case 3:
                    manager.deposit();
                    break;
                case 4:
                    manager.withdraw();
                    break;
                case 5:
                    manager.viewHistory();
                    break;
                case 6:
                    System.out.println("종료합니다.");
                    manager.disConnect();
                    return;
                default:
                    System.out.println("잘못누르셧습니다.\n다시선택해주세요.");
                    break;
            }
        }

    }
}
