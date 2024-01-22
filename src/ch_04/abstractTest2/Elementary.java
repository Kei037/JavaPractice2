package ch_04.abstractTest2;

public class Elementary extends Student{
    public Elementary(String name, int grade) {
        super(name, grade);
        System.out.println("Elementary 생성자 호출");
    }

    public String getClassTeacher() {
        return "박길순 선생님";
    }
}
