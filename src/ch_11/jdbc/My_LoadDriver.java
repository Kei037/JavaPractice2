package ch_11.jdbc;

public class My_LoadDriver {
    // 드라이버 클래스를 로드
    public static void loadDriver() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver Load Success!");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        loadDriver();
    }

}
