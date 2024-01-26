package ch_08.hashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java"); // Java는 한 번만 저장됨
        set.add("iBATIS");

        int size = set.size(); // 저장된 객체 수 얻기
        System.out.println("총 객체수: " + size);

        System.out.println("foreach 문으로 출력 시작");
        for (String s : set) {
            System.out.println("\t" + s);
        }
        System.out.println();

        System.out.println("hasNext()를 사용한 while문으로 출력");
        Iterator<String> iterator = set.iterator(); // 반복자 얻기
        while (iterator.hasNext()) { // 객체 수 만큼 루핑
            String element = iterator.next();
            System.out.println("\t" + element);
        }
        System.out.println();

        set.remove("JDBC");
        set.remove("iBATIS");

        System.out.println("foreach 문으로 출력 시작");
        for (String s : set) {
            System.out.println("\t" + s);
        }
        System.out.println();
    }
}
