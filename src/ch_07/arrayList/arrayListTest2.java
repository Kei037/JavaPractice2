package ch_07.arrayList;

import java.util.ArrayList;
import java.util.List;

public class arrayListTest2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("Java");
        list.add("JDBC");
        list.add("Servlet/JSP");
        list.add(2, "Database");
        list.add("iBATIS");

        int size = list.size();  // 저장된 총 객체수 얻기
        System.out.println("총 객체수: " + size);
        System.out.println();

        String skill = list.get(2); // 2번 인덱스에 저장된 객체 얻기
        System.out.println("2: " + skill); // 2: Database
        System.out.println();

        // 저장된 객체 출력
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(i + ":" + str);
        }

        System.out.println();
        for (String str : list) { // foreach로도 출력가능 저장된 개수 만큼만 반복되기 때문에 null 체크가 필요없음
            System.out.println(str);
        }
        System.out.println();

        list.remove(2); // 2번 인덱스 Database 삭제
        list.remove(2); // 2번 인덱스 Serverlet/JSP 삭제
        list.remove("iBATIS");

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(i + ":" + str);
        }
    }
}
