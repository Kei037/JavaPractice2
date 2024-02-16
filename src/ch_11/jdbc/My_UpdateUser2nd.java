package ch_11.jdbc;

import java.sql.SQLException;

public class My_UpdateUser2nd {
    // 수정하는 경우에도 아이디 중복 체크 하도록
    // 콘솔로 정보입력받는 메서드가 아닌 데이터베이스 처리하는 메서드에서 체크 하도록 updateUser()
    public static void main(String[] ags) throws SQLException {
        DBUpdate2 myDB = new DBUpdate2();
        myDB.connectDB(); // DB 클래스에 선언된 메서드
        myDB.getAllUser(); // DBSelect 클래스에 선언된 메서드
        myDB.updateUser();
        myDB.getAllUser(); // DBSelect 클래스에 선언된 메서드
        myDB.closeDB(); // DB 클래스에 선언된 메서드
    }
}
