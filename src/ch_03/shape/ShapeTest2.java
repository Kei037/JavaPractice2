package ch_03.shape;

public class ShapeTest2 {
    public static void print(Shape shape) {
        // Shape shape 매개 변수로 Shape에서 파생된 모든 클래스의 객체를 받을 수 있음
        System.out.println("x = " + shape.x + " y = " + shape.y);
    }

    public static void main(String[] args) {
        Rectangle shape1 = new Rectangle();
        Triangle shape2 = new Triangle();
        Circle shape3 = new Circle();

        print(shape1);
        print(shape2);
        print(shape3);
    }
}
