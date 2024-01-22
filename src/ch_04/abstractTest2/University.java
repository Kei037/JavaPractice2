package ch_04.abstractTest2;

public class University extends Student {
    private int courses;
    public University(String name, int grade, int courses) {
        super(name, grade);
        this.courses = courses;
        System.out.println("University 생성자 호출");
    }

    @Override
    public String getStudInfo() {
        System.out.println("University 클래스의 getStudInfo 메소드 호출");
        return "이름은>> " + getName() + ", 학년은>> " + getGrade() + ", 신청 학점은>> " + courses;
    }

    // 지도 교수의 이름을 구하는 메서드
    public String getProfessor() {
        return "김경순 교수님";
    }
}
