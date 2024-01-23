package ch_05.interfaceTest;

public class Television implements RemoteControl {
    boolean on;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("TV가 켜졌습니다.");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("TV가 꺼졌습니다.");
    }
}
