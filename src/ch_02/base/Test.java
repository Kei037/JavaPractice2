package ch_02.base;

class Parant {
    int x = 10;
}

class Child extends Parant {
    int x = 20;
    void method() {
        int x = 30;
        System.out.println("x = " + x);
        System.out.println("this.x = " + this.x);
        /* supuer : 상속을 하면 자식의 멤버(변수, 메서드)와 이름이 겹치게 될 때가 있는데 이를 구분하기 위해
        super.변수 supuer.메서드()를 사용하면 자식의 멤버가 호출되지 않고 상속받은 부모의 멤버를 호출할 수 있게 됩니다. */
        System.out.println("super.x = " + super.x);
    }
}

public class Test {
    public static void main(String[] args) {
        Child c = new Child();
        c.method();
        /*
        x = 30
        this.x = 20
        super.x = 10
         */
    }
}
