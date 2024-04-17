package ch_11.mvc.account_test.Model.DAO;

import ch_11.mvc.account_test.Model.DTO.Account;
import ch_11.mvc.account_test.Model.DTO.AccountHistory;
import ch_11.mvc.account_test.Model.DTO.Member;

import java.sql.*;
import java.util.ArrayList;

public class AccountDAO implements IAccountDao {
    private Connection connection = null;

    public AccountDAO() { getConnection(); }

    @Override
    public void getConnection() { // DB 연결
        try {
            String url = "jdbc:mariadb://localhost:3306/db_study_test";
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

    @Override
    public boolean insertMember(Member member) {
        // 회원가입
        String sql = "INSERT INTO member (id, name, age, addr) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, member.getId());
            preparedStatement.setString(2, member.getName());
            preparedStatement.setInt(3, member.getAge());
            preparedStatement.setString(4, member.getAddr());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insertAccount(Account account) {
        // 계좌생성
        String sql = "INSERT INTO account VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, account.getId());
            preparedStatement.setString(2, account.getActype());
            preparedStatement.setString(3, account.getAcnum());
            preparedStatement.setDouble(4, account.getBalance());
            preparedStatement.setDouble(5, account.getRate());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertAccountHistory(AccountHistory accountHistory) {
        // 거래 내역 입력
        String sql = "INSERT INTO accountHistory (acnum, transtype, amount, balance) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, accountHistory.getAcnum());
            preparedStatement.setString(2, accountHistory.getTranstype());
            preparedStatement.setDouble(3, accountHistory.getAmount());
            preparedStatement.setDouble(4, accountHistory.getBalance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<AccountHistory> selectAccountHistories(String accountId) {
        // 거래 내역 조회
        ArrayList<AccountHistory> list = new ArrayList<>();

        String sql = "SELECT * FROM accountHistory WHERE (acnum = ?) ORDER BY no DESC";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, accountId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    AccountHistory accountHistory = new AccountHistory();
                    accountHistory.setAcnum(resultSet.getString("acnum"));
                    accountHistory.setTranstype(resultSet.getString("transtype"));
                    accountHistory.setAmount(resultSet.getDouble("amount"));
                    accountHistory.setBalance(resultSet.getDouble("balance"));
                    list.add(accountHistory);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void disConnect() { // DB 연결 해제
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account selectAccount(String accountId) {
        // 계좌번호 해당 계좌 조회
        Account account = null;

        String sql = "SELECT * FROM account WHERE (acnum = ?) ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, accountId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    account = new Account();
                    account.setId(resultSet.getString("id"));
                    account.setActype(resultSet.getString("actype"));
                    account.setAcnum(resultSet.getString("acnum"));
                    account.setBalance(resultSet.getDouble("balance"));
                    account.setRate(resultSet.getDouble("rate"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public ArrayList<Account> selectAccountType(String accountId) {
        // 회원의 계좌목록 조회
        ArrayList<Account> list = new ArrayList<>();

        String sql = "SELECT * FROM account WHERE (id = ?) ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, accountId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Account account = new Account();
                    account.setId(resultSet.getString("id"));
                    account.setActype(resultSet.getString("actype"));
                    account.setAcnum(resultSet.getString("acnum"));
                    account.setBalance(resultSet.getDouble("balance"));
                    account.setRate(resultSet.getDouble("rate"));
                    list.add(account);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public double selectBalance(String accountId) {
        // 잔액 조회
        double balance = 0;

        String sql = "SELECT * FROM account WHERE (acnum = ?) ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, accountId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    balance = resultSet.getDouble("balance");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }

    @Override
    public void updateBalance(String accountId, double balance) {
        /* 입금, 출금 처리 */
        String sql = "UPDATE account SET balance = ? WHERE (acnum = ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, balance);
            preparedStatement.setString(2, accountId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int selectAccountIdCnt(String accountId) {
        // 계좌번호 있는지 확인
        String sql = "SELECT COUNT(*) AS cnt FROM account WHERE acnum = ? ";
        int cnt;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, accountId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                cnt = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cnt;
    }

    @Override
    public int selectMemberIdCnt(String memberId) {
        // 회원 아이디 있는지 확인
        String sql = "SELECT COUNT(*) AS cnt FROM member WHERE id = ? ";
        int cnt;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, memberId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                cnt = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cnt;
    }
}
