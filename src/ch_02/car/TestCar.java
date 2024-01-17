package ch_02.car;

class Car {  // 부모 클래스
    int speed;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}

class ElectricCar extends Car {  // 자식 클래스
    int battery;
    public void charge(int amount) {
        battery += amount;
    }
}

public class TestCar {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.speed = 10;
        electricCar.setSpeed(60);

        electricCar.charge(10);
    }
}
