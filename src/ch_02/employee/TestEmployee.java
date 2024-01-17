package ch_02.employee;

/*
일반직원을 Employee 클래스로 모델링한다.
Employee 클래스를 상속받아서 1) 관리자를 나타내는 Manager 클래스와 2) 프로그래머를 나타내는 Programmer 클래스를 작성한다.
Employee 클래스 안에는 월급을 계산하는 getSalary()메서드가 있다
이 메서드를 Manager 클래스와 Programmer 클래스에서 오버라이딩해서 각 직급별로 다른 월급을 반환하도록 한다.
4) 오버라이딩을 할때 Employee 클래스의 baseSalary을 사용하라
 */

class Employee {
    private int baseSalary = 300000; // 기본급
    public int getSalary() {
        return baseSalary;
    }
}

class Manager extends Employee {
    private int salary = 200000;
    @Override
    public int getSalary() {
        return (super.getSalary() + salary);
    }
}

class Programmer extends Employee {
    private int salary = 300000;
    @Override
    public int getSalary() {
        return (super.getSalary() + salary);
    }
}

public class TestEmployee {
    public static void main(String[] args) {
        Manager manager = new Manager();
        System.out.println("관리자의 월급 : " + manager.getSalary());

        Programmer programmer = new Programmer();
        System.out.println("프로그래머의 월급 : " + programmer.getSalary());
    }
}
