package ch_11.jdbc;

import java.sql.SQLException;

public class DBUpdate2 extends DBUpdate {
    private boolean isDupUserID(String userID) throws SQLException {
        // 중복되면 true 반환
        int totalRow; // 레코드 수를 저장
        String sql = "SELECT * FROM tUser WHERE userID = ?";

        preparedStatement = conn.prepareStatement(sql); // 쿼리 실행준비
        // ?에 들어갈 값을 지정해주는데, ?는 순서에 따라 1번부터 번호가 부여
        preparedStatement.setString(1, userID);
        resultSet = preparedStatement.executeQuery();

        // ResultSet의 개수를 구하는 메서드는 없어서 다른 방법으로 개수를 구함
        resultSet.last(); // 마지막 row로 이동
        totalRow = resultSet.getRow(); // row count를 추출
        resultSet.beforeFirst(); // 처음 row로 커서를 이동 (초기 상태로 돌려놓음)

        return totalRow == 1;
    }

    public void updateUser() throws SQLException {
        User user = modifyUser();
        if (isDupUserID(user.userID)) {
            System.out.println(user.userID + "는 없는 아이디 입니다.");
            return;
        }

        String updateSQL = "UPDATE tUser SET name = ?, age = ?, job = ? WHERE userID = ?";

        preparedStatement = conn.prepareStatement(updateSQL);
        // ? 자리에 순서대로 데이터 입력
        preparedStatement.setString(1, user.name);
        preparedStatement.setInt(2, user.age);
        preparedStatement.setString(3, user.job);
        preparedStatement.setString(4, user.userID);
        int cnt = preparedStatement.executeUpdate(); // 영향을 받은 데이터 갯수 반환
        // pstmt.excuteQuery() : select
        // pstmt.excuteUpdate() : insert, update, delete..

        if (cnt == 1) {
            System.out.println("영향 받은 데이터 : " + cnt);
            System.out.println("데이터 수정에 성공했습니다.");
        } else {
            System.out.println("데이터 수정에 실패했습니다.");
        }
    }
}
