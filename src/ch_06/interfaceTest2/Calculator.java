package ch_06.interfaceTest2;

public abstract class Calculator implements Calc {
    // 인터페이스를 구현한 추상클래스
    // 추상클래스의 경우 인터페이스의 모든 추상 메서드를 구현하지 않아도 됨


    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int subtract(int num1, int num2) {
        return num1 - num2;
    }
}
