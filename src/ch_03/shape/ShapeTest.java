package ch_03.shape;

class Shape {
    /*
    각 도형들을 2차원 공간에서 도형의 위치를 나타내는 기준점(x, y)를 가짐
    이것은 모든 도형에 공통적인 속성이므로 부모 클래스인 shape에 저장
    * */
    protected int x, y;
    public void draw() {
        System.out.println("Shape Draw");
    }
}

class Rectangle extends Shape {
    /*
    Shape을 상속받는 클래스
    */
    public int width, height;

    @Override
    public void draw() {
        System.out.println("Rectangle Draw");
    }

}

class Triangle extends Shape {
    public int base, height;

    @Override
    public void draw() {
        System.out.println("Triangle Draw");
    }
}

class Circle extends Shape {
    public int base, height;

    @Override
    public void draw() {
        System.out.println("Circle Draw");
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        /*
        Shape shape1, shape2;

        shape1 = new Shape();
        shape2 = new Rectangle();  // Rectangle 객체를 shape 타입의 변수로 가르킴
        */

        Shape shape = new Rectangle(); // Rectangle의 객체를 shape 형 변수에서 참조

        // Shape형 클래스의 변수에는 접근가능
        shape.x = 0;
        shape.y = 0;

        // 컴파일 오류. shape형의 참조변수로는 Rectangle의 클래스의 변수와 메서드에는 접근이 안됨
        //shape.width = 0;
        shape.draw();

        Rectangle rectangle = new Rectangle();
        rectangle.width = 0;

        // Rectangle shape1 = new Shape();

        Shape[] shapes = new Shape[3];

        // 다형성에 의해 Shape를 상속받는 모든 클래스 객체를 저장
        shapes[0] = new Rectangle();
        shapes[1] = new Triangle();
        shapes[2] = new Circle();

        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw();  // 서로다른 draw() 메서드가 실행
        }
    }
}
