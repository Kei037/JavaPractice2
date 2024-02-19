package ch_11.jdbc;

public class DBCreate extends DB { // 상속을 사용
    public void createTableUser() {
        String tableName = "tuser";
        String sql = "CREATE TABLE " + tableName + " (userID VARCHAR(100) PRIMARY KEY, "
                + "name VARCHAR(100), age INT, job VARCHAR(100))";
        createTable(tableName, sql);
    }

    public void createTable(String tableName, String sql) {
        // 테이블을 생성하는 메서드
        // 생성할 테이블 이름과 생성하는 sql 문을 매개 변수로 받음
        // 1) 테이블이 존재하는지 확인 후  2) 없으면 생성
        System.out.println(sql);
        try {
            // 테이블이 존재 하는지 확인
            String tableSql = "show tables";
            boolean isTable = false;

            // 아래 두 항목은 부모 클래스에서 정의
            // SQL문을 전송할 수 있는 PreparedStatement 객체를 생성
            preparedStatement = conn.prepareStatement(tableSql); // 쿼리 실행 준비
            resultSet = preparedStatement.executeQuery(); // 쿼리 실행 후 결과 받음
            while (resultSet.next()) {
                if (tableName.equals(resultSet.getString(1))) { // 동일한 테이블이 있는 경우
                    isTable = true;
                    break;
                }
            }

            if (isTable) { // 테이블이 존재하는 경우
                System.out.println(tableName + " 이란 이름의 테이블이 이미 존재합니다.");
            } else { // 테이블이 없는 경우 생성한다
                preparedStatement = conn.prepareStatement(sql); // 쿼리 실행 준비
                resultSet = preparedStatement.executeQuery();   // 쿼리 실행 후 결과 받음
                // System.out.println(resultSet); // org.mariadb.jdbc.client.result.CompleteResult@3c5a99da
                if (resultSet != null) {
                    System.out.println(tableName + " 테이블 생성에 성공했습니다.");
                } else {
                    System.out.println(tableName + "테이블 생성에 실패했습니다.");
                }
            }

        } catch (Exception e) {
            System.out.println("db connect err : " + e);
        }
    }
}
