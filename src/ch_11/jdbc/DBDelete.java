package ch_11.jdbc;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBDelete extends DBSelect {
    public void deleteUser() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("삭제 할 유저의 아이디를 입력하세요: ");
        String userID = scanner.nextLine();

        String deleteSQL = "DELETE FROM tUser WHERE userID='" + userID + "'";

//        preparedStatement = conn.prepareStatement(deleteSQL); // 쿼리 실행 준비
//        int cnt = preparedStatement.executeUpdate(); // 영향을 받은 데이터 갯수 반환

        Statement statement = conn.createStatement();
        int cnt = statement.executeUpdate(deleteSQL);

        if (cnt == 1) {
            System.out.println("영향 받은 데이터 : :" + cnt);
            System.out.println("데이터 삭재에 성공했습니다.");
        } else {
            System.out.println("데이터 삭제에 실패했습니다.");
        }
        scanner.close();
    }
}
