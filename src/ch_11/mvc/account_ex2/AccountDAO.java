package ch_11.mvc.account_ex2;

import java.sql.*;
import java.util.ArrayList;

public class AccountDAO {
    /* DB 서버와 접속하고 레코드를 처리하는 기능
    데이터베이스 처리에 관한 기능만으로 구성되는 객체를 DAO Data Access Object 객체라고 함 */
    private Connection connection = null;
    AccountDAO() { getConnection(); }

    private void getConnection() {
        // 디비 연결, 생성자에서 실행
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

    public int selectAccountCnt(int id) {
        /* 해당 계좌번호의 계좌가 있는지 리턴 */
        String sql = "SELECT COUNT(*) AS cnt FROM account WHERE id = ? ";
        int cnt;
        // try-with-resources 사용으로 preparedStatement는 자동으로 close됨. 즉 close 코딩을 안해도 됨
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                cnt = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cnt;
    }

    public boolean insertAccount(Account account) {
        // 계좌생성
        String sql = "INSERT INTO account VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setString(2, account.getName());
            preparedStatement.setLong(3, account.getBalance());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateBalance(int id, long money, boolean flag) {
        /* 입금, 출금 처리
        flag로 입금, 출금 구분  true : 입금 / false : 출금 */
        String sql;
        int cnt = 0;
        if (flag) { // 입금
            sql = "UPDATE account SET balance = balance + ? WHERE (id = ?)";
        } else { // 출금
            sql = "UPDATE account SET balance = balance - ? WHERE (id = ?)";
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, money);
            preparedStatement.setInt(2, id);

            cnt = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cnt == 1;
    }

    public Account selectOne(int id) {
        // 계좌 번호를 받아 계좌 정보 전달
        Account account = null;
        String sql = "SELECT * FROM account WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) { // 데이터에 접근하기 위해서는 무조건 next() 실행
                    account = new Account();
                    account.setId(resultSet.getInt("id"));
                    account.setName(resultSet.getString("name"));
                    account.setBalance(resultSet.getInt("balance"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public ArrayList<Account> selectAll() {
        // 전체 정보 반환
        String sql = "SELECT * FROM account ";
        ArrayList<Account> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Account account = new Account(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("balance"));
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void disConnect() { // 연결 해제. 서비스 종료시에 사용
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

