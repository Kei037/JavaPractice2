package ch_04.abstractTest2;

public class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
        System.out.println("Student 생성자 호출");
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public String getStudInfo() {
        System.out.println("Student 클래스의 getStudInfo()메소드 호출");
        return "이름은 : " + name + " , 학년은 " + grade;
    }

    //학생의 담임선생님의 이름을 구하는 메소드
    public String getTeacher() {
        return "김길동 선생님";
    }
}
