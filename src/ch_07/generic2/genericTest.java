package ch_07.generic2;
/* Generic은 C++의 템플릿이 발전한 형태
C++과 달리 제네릭 대신 Object를 사용하면 모든 데이터 타입을 사용할 수 있지만,
경우에 따라 형 변환 해줘야 되서 제네릭을 선호 */
// 일반적인 방식으로는 클래스에서 미리 데이터 타입을 지정해야 하지만 제네릭을 사용하면 호출하는 쪽에서 데이터 타입을 지정
class ObjectData<T> {
    private T data; // 데이터 타입으로 T를 지정. Type의 약자 클래스 선언에서 <> 사이에 다른 문자를 넣어도 됨

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

public class genericTest {
    public static void main(String[] args) {
        ObjectData<String> stringCommonData = new ObjectData<String>();
        ObjectData<Integer> integerCommonData = new ObjectData<>();

        stringCommonData.setData("abc"); // 클래스의 데이터 타입이 Object라서 모든 데이터 타입이 사용 가능
        integerCommonData.setData(100);

        System.out.println("stringCommonData : " + stringCommonData.getData());
        System.out.println("integerCommonData : " + integerCommonData.getData());

        String tmp = stringCommonData.getData();
        System.out.println("tmp : " + tmp);
    }
}
