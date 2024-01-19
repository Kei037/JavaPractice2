package ch_03.shape;

public class ShapeTest3 {
    public static void print(Shape obj) {
        if (obj instanceof Rectangle) System.out.println("실제 타입은 Rectangle");
        if (obj instanceof Triangle) System.out.println("실제 타입은 Triangle");
        if (obj instanceof Circle) System.out.println("실제 타입은 Circle");
    }

    public static void main(String[] args) {
        Rectangle shape1 = new Rectangle();
        print(shape1);

        Triangle shape2 = new Triangle();
        Circle shape3 = new Circle();

        print(shape2);
        print(shape3);
    }
}
