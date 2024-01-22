package ch_04.abstractTest;

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public abstract void bark();       // 짖는다
    public abstract String toString(); // 문자열 표현을 반환

    public void introduce() {
        System.out.println(toString() + "입니다.");
        bark();
    }
}

class Cat extends Animal {
    private int age;

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public void bark() {
        System.out.println("냐옹!!");
    }

    @Override
    public String toString() {
        return age + "살인 " + getName();
    }  // 고양이 클래스

}

class Dog extends Animal {
    private String type;

    public Dog(String name, String type) {
        super(name);
        this.type = type;
    }


    @Override
    public void bark() {
        System.out.println("멍멍!!");
    }

    @Override
    public String toString() {
        return type + "인 " + getName();
    }
}

public class TestAnimal {
    public static void main(String[] args) {
        // Anima animal = new Aimal();  // 추상클래스 단독으로는 객체 생성이 안됨
        // 추상클래스로 다형성에 이용가능
        Animal[] animals = {
                new Dog("바둑이", "삽살개"),
                new Cat("아룽이", 7),
                new Dog("백두", "진돗개")
        };

        for (Animal animal : animals) {
            animal.introduce();     // animal가 참조하고 있는 인스턴스의 형에 따라서
            System.out.println();   // 메소드가 호출된다
        }
    }
}
