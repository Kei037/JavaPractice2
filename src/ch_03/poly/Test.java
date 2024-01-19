package ch_03.poly;

class Car {
    String color;
    int door;

    void drive() {
        System.out.println("drive, Brrrr~");
    }

    void Stop() {
        System.out.println("stop!!!");
    }
}

class FireEngine extends Car {
    void water() {
        System.out.println("water!!!");
    }
}

public class Test {
    public static void main(String[] args) {
        /* 다형성과 현변환
        자식 타입에서 부모타입으로는 자동 형변환되지만, 부모에서 자식타입으로는 명시적 형변환
         */
        FireEngine fireEngine = new FireEngine();
        fireEngine.drive();
        fireEngine.water();

        Car car = fireEngine;  // car = (Car)fireEngine;에서 형변환이 생략된 형태
        car.drive();
        // car.water();  // Car타입의 참조변수로는 water()를 호출 불가능

        FireEngine fireEngine2 = (FireEngine) car;
        fireEngine2.drive();
        fireEngine2.water();
    }
}
