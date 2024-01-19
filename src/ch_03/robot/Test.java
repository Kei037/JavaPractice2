package ch_03.robot;

class Robot {}

class DanceRobot extends Robot {
    void dance() { System.out.println("춤을 춥니다."); }
}

class SingeRobot extends Robot {
    void sing() { System.out.println("노래를 합니다."); }
}

class DrawRobot extends Robot {
    void draw() { System.out.println("그림을 그립니다."); }
}

public class Test {
    /*
    1) instanceof를 사용해서 객체의 타입에 맞는 메서드가 실행되는 action메서드를 작성하시오.
     */
    public static void action(Robot robot) {
        if (robot instanceof DanceRobot) { ((DanceRobot) robot).dance(); }
        if (robot instanceof SingeRobot) { ((SingeRobot) robot).sing(); }
        if (robot instanceof DrawRobot) { ((DrawRobot) robot).draw(); }
    }

    public static void main(String[] args) {
        Robot[] robots = { new DanceRobot(), new SingeRobot(), new DrawRobot() };

        for (Robot robot : robots) {
            action(robot);
        }
    }
}
