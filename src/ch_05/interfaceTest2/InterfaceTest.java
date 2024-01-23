package ch_05.interfaceTest2;

interface MyInterface {
    // 아래 코드 모두 public static final 이 자동으로 붙음
    int w = 10;
    static int x = 20;
    final int y = 30;
    public static final int z = 40;

}

public class InterfaceTest {
    public static void main(String[] args) {
        // MyInterface mi = new MyInterface(); // 인터페이스는 객체 생성이 안됨
        // MyInterface.w 50; // 상수라서 값 변경도 안됨
        System.out.println("w = " + MyInterface.w);
        System.out.println("x = " + MyInterface.x);
        System.out.println("y = " + MyInterface.y);
        System.out.println("z = " + MyInterface.z);
    }
}
