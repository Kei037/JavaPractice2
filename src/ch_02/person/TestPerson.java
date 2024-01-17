package ch_02.person;

class Person {
    void breath() {
        System.out.println("숨쉬기");
    }
    void eat() {
        System.out.println("밥먹기");
    }
    void say() {
        System.out.println("말하기");
    }
}

class Student extends Person {
    void learn() {
        System.out.println("배우기");
    }
}

class Teacher extends Person {
    void teach() {
        System.out.print("가르치기");
    }
}

public class TestPerson {
    public static void main(String[] args) {
        Student student = new Student();  // 학생 인스턴스 student 생성
        student.breath();  // 사람 클래스의 breath 메서드를 상속 받았음
        student.learn();
        student.say();

        Teacher teacher = new Teacher();  // 학생 인스턴스 teacher 생성
        teacher.eat();  // 사람 클래스의 eat 메서드를 상속 받았음
        teacher.teach();
        teacher.say();

        Person person = new Person();
        person.breath();
//        person.learn(); 자식 클래스의 메서드나 멤버 변수는 사용하지 못함
    }
}
