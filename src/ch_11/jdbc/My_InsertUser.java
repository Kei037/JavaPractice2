package ch_11.jdbc;

import java.sql.SQLException;

public class My_InsertUser {
    public static void main(String[] args) throws SQLException {
        DBInsert myDB = new DBInsert();
        myDB.connectDB();
        myDB.insertUser();
        myDB.closeDB();
    }
}
