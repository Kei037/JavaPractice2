package ch_04.abstractTest3;

public class Test {
    public static void main(String[] args) {
        University university = new University("홍길동", 2, 22, "차범근");
        Elementary elementary = new Elementary("박지성", 3, "홍명보");

        // 선생님 혹은 교수님의 이름을 호출
        Student[] students = new Student[2];
        students[0] = university;
        students[1] = elementary;
        for (Student student : students) {
            System.out.println("학생 이름:" + student.getName());
            System.out.println(student.getTeacher());
        }
    }
}
