package ch_05.interfaceTest6;

interface Flyable {
    void fly();
}

class Car {
    int speed;
    void setSpeed(int speed) {
        this.speed = speed;
    }
}

public class FlyingCar extends Car implements Flyable {
    public void fly() {
        System.out.println("i'm flying!");
    }

    public static void main(String[] args) {
        FlyingCar flyingCar = new FlyingCar();
        flyingCar.setSpeed(300);
        flyingCar.fly();
    }
}
