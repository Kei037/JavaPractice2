package ch_07.generic;
/* Generic은 C++의 템플릿이 발전한 형태
C++과 달리 제네릭 대신 Object를 사용하면 모든 데이터 타입을 사용할 수 있지만,
경우에 따라 형 변환 해줘야 되서 제네릭을 선호 */

class ObjectData {
    private Object data; // 클래스의 데이터 타입이 Object라서 모든 데이터 타입이 사용 가능

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

public class genericTest {
    public static void main(String[] args) {
        ObjectData stringCommonData = new ObjectData();
        ObjectData integerCommonData = new ObjectData();

        stringCommonData.setData("abc"); // 클래스의 데이터 타입이 Object라서 모든 데이터 타입이 사용 가능
        integerCommonData.setData(100);

        System.out.println("stringCommonData : " + stringCommonData.getData());
        System.out.println("integerCommonData : " + integerCommonData.getData());

        // String tmp = stringCommonData.getData();
    }
}
