package ch_01;

public class Method_10 {
    /*
    메서드 오버로딩
    C, 파이썬, 자바스크립트에는 없는 기능. 메게변수의 1)타입 혹은 2)갯수가 다르면 같은이름을 가진 메서드를 재정의 할 수 있음

    C++, 파이썬, 자바스크립트에 있는 기본값 매개변수 기능은 자바에 없음
     */
    public static void printGreet() {
        System.out.println("printGreet() 메서드가 실행됩니다.");
        System.out.println("안녕하세요");
    }

    public static void printGreet(String greeting) {
        System.out.println("printGreet(String greeting) 메서드가 실행됩니다.");
        System.out.println(greeting);
    }

    public static void printGreet(String name, String greeting) {
        System.out.println("printGreet(String greeting String greeting) 메서드가 실행됩니다.");
        System.out.println(name + "님!" + greeting);
    }

    public static void printGreet(int x) {
        System.out.println("printGreet(int x) 메서드가 실행됩니다.");
        System.out.println("정수형 " + x);
    }

    public static void main(String[] args) {
        printGreet();  // 안녕하세요
        printGreet("안녕~!");
        printGreet("한수", "잘 지내셧나요?");
        printGreet(3);
    }
}
