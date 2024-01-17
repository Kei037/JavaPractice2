package ch_02.draw;

class Shape {
    public void draw() {
        System.out.println("Shape 중의 하나를 그릴 예정입니다.");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle을 그립니다.");
    }
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        super.draw();
        System.out.println("Rectangle 그립니다.");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle 그립니다.");
    }
}

public class TestShape {
    public static void main(String[] args) {
        Rectangle s = new Rectangle();
        s.draw();
    }
}
