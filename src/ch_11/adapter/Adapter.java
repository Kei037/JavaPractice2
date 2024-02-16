package ch_11.adapter;

// 어댑터를 번역하면 변환기 converter라고 할 수 있음.
// 변환그의 역할은 서로 다른 두 인터페이스 사이에 통신이 가능하게 하는 것
interface AdapterService {
    void runService();
}

class AdapterServiceA implements AdapterService {
    WorkMan workMan = new WorkMan();

    @Override
    public void runService() { workMan.runWork(); }
}

class AdapterServiceB implements AdapterService {
    StudyStudent studyStudent = new StudyStudent();

    @Override
    public void runService() { studyStudent.runStudy(); }
}

public class Adapter {
    public static void main(String[] args) {
        AdapterService asa1 = new AdapterServiceA();
        AdapterService asb1 = new AdapterServiceB();

        // 동일한 메서드 명을 사용할 수 있음
        asa1.runService();
        asb1.runService();
    }
}
