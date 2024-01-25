package ch_07.linkedList;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // List<String> linkedList = new LinkedList<>(); // List로 선언시 addFirst(), removeList() 사용 못함
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        System.out.println(linkedList); // 리스트 전체 출력 [A, B, C]

        linkedList.add(1, "D");
        System.out.println(linkedList); //  [A, D, B, C]

        linkedList.addFirst("O");
        System.out.println(linkedList); //  [O, A, D, B, C]

        System.out.println(linkedList.removeLast()); // 맨 뒤의 요소 삭제 및 반환. LinkedList에서 사용
        System.out.println(linkedList); // [O, A, D, B]
    }
}
