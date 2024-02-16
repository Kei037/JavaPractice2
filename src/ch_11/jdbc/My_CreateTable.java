package ch_11.jdbc;

import java.sql.SQLException;

public class My_CreateTable {
    public static void main(String[] args) throws SQLException {
        DBCreate myDB = new DBCreate();
        myDB.connectDB();
        myDB.createTableUser();
        myDB.closeDB();
    }
}
