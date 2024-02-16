package ch_11.mvc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
    private ArrayList<Account> list;
    private Scanner stdIn;
    private Connection connection = null;

    public AccountManager() {
        getConnection();
        list = new ArrayList<>();
        stdIn = new Scanner(System.in);
    }

    // 디비 관련
    private void getConnection() { // 디비 연결
        // 생성자에서 실행
        try {
            String url = "jdbc:mariadb://localhost:3306/sample_java";
            String user = "root";
            String password = "3432";

            try {
                Class.forName("org.mariadb.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disConnect() { // 연결 해제. 서비스 종료시에 사용

    }

    public void makeAccount() { // 계좌 개설
        Account account = new Account();

        System.out.print("계좌 번호: ");
        account.setId(stdIn.nextInt());

        System.out.print("이름: ");
        account.setName(stdIn.next());

        System.out.print("입금액: ");
        account.setBalance(stdIn.nextLong());

//        list.add(account);
        if (addAccount(account)) {
            System.out.println("계좌가 개설되었습니다.");
//            System.out.println(list.toString() + "\t");
        } else {
            System.out.println("계좌가 생성에 실패했습니다.");
        }
    }

    public void deposit() { // 입금
        System.out.print("계좌번호: ");
        int id = stdIn.nextInt();

        System.out.print("입금액: ");
        long money = stdIn.nextLong();

        // 해당 계좌 찾기
        for (Account account : list) {
            if (account.getId() == id) { // 동일한 계좌가 있다면
                account.setBalance(money + account.getBalance());
                System.out.println("입금완료 되었습니다.");
                return;
            }
        }
        System.out.println("해당 계좌번호가 존재하지 않습니다.");
    }

    public void withdraw() { // 출금
        System.out.print("계좌번호: ");
        int id = stdIn.nextInt();

        System.out.print("출금액: ");
        long money = stdIn.nextLong();

        // 해당 계좌 찾기
        for (Account account : list) {
            if (account.getId() == id) { // 동일한 계좌가 있다면
                if (account.getBalance() < money) {
                    System.out.println("잔액이 부족합니다.");
                } else {
                    account.setBalance(account.getBalance() - money);
                    System.out.println("출금완료 되었습니다.");
                }
                return;
            }
        }
        System.out.println("해당 계좌번호가 존재하지 않습니다.");
    }

    public void inquire() { // 잔액 조회
        System.out.print("계좌번호: ");
        int id = stdIn.nextInt();

        // 해당 계좌 찾기
        for (Account account : list) {
            if (account.getId() == id) { // 동일한 계좌가 있다면
                System.out.println(account.getId() + "\t" + account.getName() + "\t" + account.getBalance());
                return;
            }
        }
        System.out.println("해당 계좌번호가 존재하지 않습니다.");
    }

    public void display() { // 출력
        ArrayList<Account> list = selectAll();
        for (Account account : list) {
            System.out.println(account.getId() + "\t" + account.getName() + "\t" + account.getBalance());
        }
    }

    private ArrayList<Account> selectAll() {
        // 전체 정보 전달
        Statement statement = null;
        ArrayList<Account> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM account ";
            System.out.println(sql);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                Account account = new Account(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getInt("balance"));
                list.add(account);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private boolean isAccount(int id) { // 동일한 계좌가 있는지
        int res = 0;

        try {
            String sql = "SELECT COUNT(*) AS cnt FROM account WHERE id = '" + id + "'";
//            System.out.println(sql);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            res = resultSet.getInt("cnt");
//            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res != 0 ? true : false;
    }

    private boolean addAccount(Account account) {
        // 계좌 생성
        Statement statement = null;
        if (isAccount(account.getId())) { // 계좌 생성전에 동일한 계좌 번호가 존해하는지 확인
            System.out.println(account.getId() + "계좌가 존재합니다.");
            return false;
        }

        boolean res = false;
        int cnt = 0;
        try {
            String sql = String.format("INSERT INTO account VALUES (%d, '%s', %d)",
                    account.getId(), account.getName(), account.getBalance());
//            System.out.println(sql);
            statement = connection.createStatement();
            cnt = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        res = (cnt == 0) ? false : true;
        return res;
    }
}
