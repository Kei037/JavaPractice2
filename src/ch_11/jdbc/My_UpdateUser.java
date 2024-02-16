package ch_11.jdbc;

import java.sql.SQLException;

public class My_UpdateUser {
    public static void main(String[] args) throws SQLException {
        DBUpdate myDB = new DBUpdate();
        myDB.connectDB();
        myDB.getAllUser();
        myDB.updateUser();
        myDB.getAllUser();
        myDB.closeDB();
    }
}
