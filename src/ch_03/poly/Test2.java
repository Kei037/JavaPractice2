package ch_03.poly;

public class Test2 {
    public static void main(String[] args) {
        /* instanceof 연산자
        a instanceof B : a는 B의 객체이면 true 반환
         */
        FireEngine fireEngine = new FireEngine();

        if (fireEngine instanceof FireEngine) System.out.println("This is a FireEngine instance"); // fireEngine은 FireEngine의 객체
        if (fireEngine instanceof Car) System.out.println("This is a Car instance"); // fireEngine은 Car 객체
        if (fireEngine instanceof Object) System.out.println("This is a Object instance"); // fireEngine은 Object 객체
        System.out.println();

        Car polyFireEngine = new FireEngine();
        if (polyFireEngine instanceof FireEngine) System.out.println("This is a FireEngine instance"); // polyFireEngine은 FireEngine의 객체
        if (polyFireEngine instanceof Car) System.out.println("This is a Car instance"); // polyFireEngine은 Car 객체
        if (polyFireEngine instanceof Object) System.out.println("This is a Object instance"); // polyFireEngine은 Object 객체
        System.out.println();

        Car car = new Car();
        if (car instanceof FireEngine) System.out.println("This is a FireEngine instance"); // car은 FireEngine의 객체
        if (car instanceof Car) System.out.println("This is a Car instance"); // car은 Car 객체
        if (car instanceof Object) System.out.println("This is a Object instance"); // car은 Object 객체

    }
}
