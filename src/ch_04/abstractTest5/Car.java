package ch_04.abstractTest5;

abstract class Car {
    abstract void start();
    abstract void drive();
    abstract void stop();
    abstract void turnOff();

    public void run() {
        start();
        drive();
        stop();
        turnOff();
    }
}
