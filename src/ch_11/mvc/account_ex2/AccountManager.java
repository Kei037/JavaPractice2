package ch_11.mvc.account_ex2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 2차 패키지에서
1) Controller 에 있는 데이터 베이스 관련 처리를 따로 분리. DAO 클래스 생성
Model은 DTO와 DAO로 구성

2) try with resourse와 PreparedStatement 사용으로 수정

3) 메서드 이름으로만으로 Controller에 있는 메서드인지, DAO에 있는 메서드인지 구분이 될 수 있도록
DAO의 메서드에는 select, insert, update, delete 단어로 메서드 이름을 시작
Controller에서는 select, insert, update, delete 사용하지 않음

4) DAO의 메서드는 메서드당 하나의 쿼리만 실행

1. AccountDAO 클래스 작성

2. 데이터 베이스 연결 메서드 getConnection()를 DAO로 이동

3. 계좌개설 makeAccount() 메서드 수정
 */

public class AccountManager {
    private final Scanner stdIn;
    private final AccountDAO accountDAO;

    public AccountManager() {
        stdIn = new Scanner(System.in);
        accountDAO = new AccountDAO();
    }

    public void makeAccount() {
        /* 계좌 개설시 정보를 입력 받음 */
        Account account = new Account();

        System.out.print("계좌 번호: ");
        account.setId(stdIn.nextInt());

        System.out.print("이름: ");
        account.setName(stdIn.next());

        System.out.print("입금액: ");
        account.setBalance(stdIn.nextLong());

        if (this.addAccount(account)) {
            System.out.println("계좌가 개설되었습니다.");
        } else {
            System.out.println("계좌가 생성에 실패했습니다.");
        }
    }

    public void deposit() { // 입금
        System.out.print("계좌번호: ");
        int id = stdIn.nextInt();

        System.out.print("입금액: ");
        long money = stdIn.nextLong();

        if (isAccount(id)) {
            accountDAO.updateBalance(id, money, true);
        } else {
            System.out.println("해당 계좌번호가 존재하지 않습니다.");
        }
    }

    public void withdraw() { // 출금
        System.out.print("계좌번호: ");
        int id = stdIn.nextInt();

        System.out.print("출금액: ");
        long money = stdIn.nextLong();

        if (!isAccount(id)) { // 해당 계좌 찾기
            System.out.println("해당 계좌번호가 존재하지 않습니다.");
            return;
        }

        Account account = accountDAO.selectOne(id);
        if (account.getBalance() < money) {
            System.out.println("잔액이 부족합니다.");
            return;
        }
        accountDAO.updateBalance(id, money, false);
        System.out.println("출금완료 되었습니다.");
    }

    public void inquire() { // 잔액 조회
        System.out.print("계좌번호: ");
        int id = stdIn.nextInt();

        Account account = accountDAO.selectOne(id);
        if (account == null) { // 해당 계좌 찾기
            System.out.println("해당 계좌번호가 존재하지 않습니다.");
            return;
        }
        System.out.println(account.getId() + "\t" + account.getName() + "\t" + account.getBalance());
    }

    public void display() { // 출력
        ArrayList<Account> list = accountDAO.selectAll(); // Account 목록을 가지고 옴
        for (Account account : list) {
            System.out.println(account.getId() + "\t" + account.getName() + "\t" + account.getBalance());
        }
    }

    public void disConnect() {
        accountDAO.disConnect();
        stdIn.close();
    }

    /* private method area */

    private boolean isAccount(int id) {
        /* 동일한 계좌가 있는지
        죽복된 계좌가 있으면 true 반환 */
        return accountDAO.selectAccountCnt(id) == 1;
    }

    private boolean addAccount(Account account) {
        // 계좌 생성
        if (this.isAccount(account.getId())) { // 계좌 생성전에 동일한 계좌 번호가 존재하는지 확인
            System.out.println(account.getId() + " 계좌가 존재합니다.");
            return false;
        }
        return accountDAO.insertAccount(account);
    }

}
