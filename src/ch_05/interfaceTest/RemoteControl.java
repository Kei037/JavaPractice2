package ch_05.interfaceTest;

interface RemoteControl {
    public void turnOn();
    public void turnOff();
}

interface AdvancedRemoteControl extends RemoteControl {
    void volumeUp();
    void volumeDown();
}