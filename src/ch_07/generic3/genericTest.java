package ch_07.generic3;
// MultipleGenericTypeTest
// 제네릭 타입 클래스 : 클래스의 객체를 생성할 때 매개변수를 사용해 특정 타입을 전달하여 이를 기반으로
// 클래스의 객체가 생성 및 작동하도록 지원하는 것.
// 어떤 문자를 사용해도 되나 미리 지정된 타입이 있음. 가급적 타입에 맞게 문자를 사용하는 것이 가독성을 높임.
// E : Element의 약자. 컬레션 프레임워크를 사용할 때 각 객체를 지칭하는 의미로 사용.
// K : Key의 약자. 키와 값이라는 쌍으로 이루어진 형태에서 '키'의 의미로 사용.
// V : Value의 약자. 키와 값이라는 쌍으로 이루어진 형태에서 '값'의 의미로 사용.
// T : Type의 약자. 자료형이나 클래스의 의미로 사용.
// 제네릭에서는 기본 자료형(boolean, byte, char, int등)을 타입으로 사용할 수 없어서 여기서는 래퍼 Wrapper 클래스를 의미.
// N : Number의 약자. 수치 계열의 의미로 사용. 여러 개를 사용할 때 각 타입 매개 변수 뒤에 2, 3, 4등의 숫자를 붙여 사용.
class IntString {
    private Integer key;
    private String value;

}

public class genericTest {
    public static void main(String[] args) {
    }
}
