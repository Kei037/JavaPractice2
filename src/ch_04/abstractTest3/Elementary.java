package ch_04.abstractTest3;

public class Elementary extends Student {
    public Elementary(String name, int grade, String teacher) {
        super.name = name;
        super.grade = grade;
        super.teacher = teacher;
        System.out.println("Elementary 생성자 호출");
    }

    public Elementary(String name, int grade) {
        super.name = name;
        super.grade = grade;
    }

    @Override
    public String getTeacher() {
        return "담당 선생님:" + super.teacher;
    }
}
