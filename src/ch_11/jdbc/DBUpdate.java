package ch_11.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class DBUpdate extends DBSelect {
    protected User modifyUser() {
        // 콘솔로 수정할 사용자 정보를 입력 받아서 리턴
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        boolean validate = false;
        String validateTemp;
        do {
            System.out.println("정보 수정 할 회원의 아이디를 입력하세요: ");
            user.userID = scanner.nextLine();
            System.out.println("회원의 이름을 입력하새요: ");
            user.name = scanner.nextLine();
            System.out.println("회원의 나이를 입력하세요: ");
            user.age = Integer.parseInt(scanner.nextLine());
            System.out.println("회원의 직업을 입력하세요: ");
            user.job = scanner.nextLine();

            System.out.println("수정 된 회원 : " + user.userID + " / " + user.name + " / " +
                    user.age + " / " + user.job + " 이 맞습니까? (y/n)");
            validateTemp = scanner.nextLine();

            // 입력 값이 y가 아닌 경우 true, 같은 경우 fasle 반환
            validate = !validateTemp.equals("y");
        } while (validate);

        scanner.close();
        return user;
    }

    protected User modifyUser2() {
        // 콘솔로 수정할 사용자 정보를 입력 받아서 리턴
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        boolean validate = false;
        String validateTemp;
        do {
            System.out.println("정보 수정 할 회원의 아이디를 입력하세요: ");
            user.userID = scanner.nextLine();
            System.out.println("회원의 아이디를 입력하세요: ");
            user.userID = scanner.nextLine();
            System.out.println("회원의 이름을 입력하새요: ");
            user.name = scanner.nextLine();
            System.out.println("회원의 나이를 입력하세요: ");
            user.age = Integer.parseInt(scanner.nextLine());
            System.out.println("회원의 직업을 입력하세요: ");
            user.job = scanner.nextLine();

            System.out.println("수정 된 회원 : " + user.userID + " / " + user.name + " / " +
                    user.age + " / " + user.job + " 이 맞습니까? (y/n)");
            validateTemp = scanner.nextLine();

            // 입력 값이 y가 아닌 경우 true, 같은 경우 fasle 반환
            validate = !validateTemp.equals("y");
        } while (validate);

        scanner.close();
        return user;
    }

    public void updateUser() throws SQLException {
        User user = modifyUser();
        if (isDupUserID(user.userID)) {
            System.out.println(user.userID + "는 중복되는 아이디 입니다.");
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

    public void updateUser2() throws SQLException {
        User user = modifyUser2();
        if (isDupUserID(user.userID)) {
            System.out.println(user.userID + "는 중복되는 아이디 입니다.");
            return;
        }

        String updateSQL = "UPDATE tUser SET userID = ?, name = ?, age = ?, job = ? WHERE userID = ?";

        preparedStatement = conn.prepareStatement(updateSQL);
        // ? 자리에 순서대로 데이터 입력
        preparedStatement.setString(1, user.userID);
        preparedStatement.setString(2, user.name);
        preparedStatement.setInt(3, user.age);
        preparedStatement.setString(4, user.job);
        preparedStatement.setString(5, user.userID);
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
}
