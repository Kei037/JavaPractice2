package ch_02.circle;

class Circle {
    protected int radius; // 반지름
    public Circle (int radius) {
        this.radius = radius;
    }
}

class Pizza extends Circle {
    private String select;

    public Pizza(String select, int radius) {
        super(radius);
        this.select = select;
    }

    public void print() {
        System.out.println("피자의 종류 : " + this.select + " 피자의 크기 : " + (super.radius * 2));
    }
}

// 원을 나타내는 Circle 클래스를 상속받아서 피자를 나타내는 Pizza 클래스를 작성해 보자
public class TestCircle {
    public static void main(String[] args) {
        Pizza pizza = new Pizza("Pepperoni", 10);
        pizza.print(); // 피자의 종류 : Pepperoni, 피자의 크기 : 20
    }
}
