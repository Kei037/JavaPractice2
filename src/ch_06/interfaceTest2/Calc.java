package ch_06.interfaceTest2;

public interface Calc {
    // 인터페이스에서 선언된 변수는 컴파일 과정에서 상수로 변환
    double PI = 3.14;
    int ERROR = -999999999;

    // 인터페이스에서 선언한 메서드는 컴파일 과정에서 추상메서드로 변환됨
    int add(int num1, int num2);
    int subtract(int num1, int num2);
    int times(int num1, int num2);
    int divide(int num1, int num2);

    // 인터페이스에 디폴트 메소드 구현
    default void description() {
        System.out.println("정수 계산기를 구현합니다.");
        myMethod();
    }
    private void myMethod() { // 디폴트 메소드에서 사용
        System.out.println("private 메서드입니다.");
    }

    // 정적 메소드 구현
    static int total(int[] arr) {
        int total = 0;

        for (int i : arr) {
            total += i;
        }
        myStaticMethod();
        return total;
    }
    // private 메서드는 코드를 모두 구현해야 하므로 추상메서드에서는 private 예약어를 사용할 수 없음
    // static 예약어는 함께 사용가능
    private static void myStaticMethod() {  // 정적 메소드에서 사용
        System.out.println("private static 메서드 입니다.");
    }
}
