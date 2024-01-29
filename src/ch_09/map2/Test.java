package ch_09.map2;

import java.util.HashMap;
import java.util.Map;

class Student { // 학번과 키가 같다면 동일한 키로 인식
    public int sno;
    public String name;

    public Student(int sno, String name) {
        this.sno = sno;
        this.name = name;
    }

    @Override
    public int hashCode() { // 학번과 이름이 같다면 동일한 값을 리턴
        return name.hashCode() + sno;
    }

    @Override
    public boolean equals(Object obj) { // 학번과 이름이 같다면 true 반환
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return (sno == student.sno) && (name.equals(student.name));
        }
        return false;
    }
}

public class Test {
    public static void main(String[] args) {
        Map<Student, Integer> map = new HashMap<>();

        map.put(new Student(1, "홍길동"), 95);
        map.put(new Student(1, "홍길동"), 95);
        map.put(new Student(1, "박유신"), 85);

        System.out.println("총 Entry수 : " + map.size()); // 저장된 총 Map.Entry 수 얻기
    }
}
