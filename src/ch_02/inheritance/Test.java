package ch_02.inheritance;

/*
속성 : 제조사(maker), 모델(model), 색상(color), 현재속도(curSpeed)
행위 : 가속(speedUp), 감속(speedDown)
1. 이 속성과 행위 설명을 바탕으로 하는 Car 클래스를 정의하라
단 가속과 감속의 결과는 curSpeed와 연동되어야 한다.
2. 정의한 Car 클래스에 파라미터로 모든 필드를 초기화하는 생성자를 추가하라.
3. Car 클래스를 상속받는 SportCar 클래스를 정의하고, 가속과 감속 메서드를 스포츠카에 맞게 구현하라
 */

class Car {
    String maker;
    String model;
    String color;
    int curSpeed;

    public Car(){}
    public Car(String maker, String model, String color, int curSpeed) {
        this.maker = maker;
        this.model = model;
        this.color = color;
        this.curSpeed = curSpeed;
    }

    public void speedUp() { this.curSpeed++; }
    public void speedDown() { this.curSpeed--; }

    @Override
    public String toString() {
        return "Car{" +
                "maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", curSpeed=" + curSpeed +
                '}';
    }

    public int getCurSpeed() {
        return curSpeed;
    }

    public String getModel() {
        return model;
    }
}

class SportCar extends Car {

    public SportCar(String maker, String model, String color, int curSpeed) {
        super(maker, model, color, curSpeed);
    }

    @Override
    public void speedUp() {
        this.curSpeed += 10;
    }

    @Override
    public void speedDown() {
        this.curSpeed -= 10;
    }
}

public class Test {
    public static void main(String[] args) {
        Car car1 = new Car("현대", "소나타", "검정", 0);
        Car car2 = new Car("테슬라", "모델1", "파랑", 0);
        SportCar sportCar = new SportCar("아우디", "a6", "회색", 0);

        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(sportCar.toString());
        System.out.println(car1.getModel());
        System.out.println();
        car1.speedUp();
        car2.speedDown();
        sportCar.speedUp();

        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(sportCar.toString());
        System.out.println(car1.getCurSpeed());
        System.out.println(sportCar.getCurSpeed());
    }
}
