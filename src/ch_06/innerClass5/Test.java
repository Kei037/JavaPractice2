package ch_06.innerClass5;

class OutClass {
    // Runnable 인터페이스를 구현하는 클래스를 지역 내부 클래스로 만든 예제
    int outNum = 100;
    static int sNum = 200;

    Runnable getRunnable(int i) { // 반환형이 Runnable인 메서드
        int num = 100;
        /* Runnable 인터페이스는 자바에서 스레드를 만들 때 사용하는 인터페이스로 java.lang 패키지에 선언되어 있으며
           반드시 run() 메서드를 구현해야함 */
        class MyRunnable implements Runnable {
            int localNum = 10;

            @Override
            public void run() {
                /* 지역 내부 클래스가 선언된 메서드의 지역변수는 사용하지 못함 */
                // num = 200; // 에러 남. 지역변수는 상수로 바뀜. 값은 변경은 못해도 보는 것은 가능
                // i = 100;   // 에러 남. 매개 변수 역시 지역변수처럼 상수로 바뀜. 값은 변경은 못해도 보느 것은 가능.
                System.out.println("i =" + i);
                System.out.println("num =" + num);
                System.out.println("localNum =" + localNum);

                System.out.println("outNum = " + outNum + "(외부 클래스 인스턴스 변수)");
                System.out.println("Outter.sNum = " + OutClass.sNum + "(외부 클래스 정적 변수)");
            }
        }
        return new MyRunnable();
    }
}

public class Test {
    public static void main(String[] args) {
        OutClass out = new OutClass();

    }
}
