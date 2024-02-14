package ch_11;

public class My_CreateTable {
    public static void main(String[] args) {
        DBCreate myDB = new DBCreate();
        myDB.connectDB();
        myDB.createTableUser();
        myDB.closeDB();
    }
}
