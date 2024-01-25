package ch_07.arrayList;

import java.util.ArrayList;

/* ArrayList : 배열에서 발전된 형태
요소를 추가하면 0번 인덱스부터 차례대로 저장
메서드를 사용해서 원하는 위치에 요소를 추가하거나, 삭제, 반환 할 수 있음 */
public class arrayListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(2); // 타입을 지정하지 않은 형태. 초기 capa값을 지정할 수도 있음
        list.add("A");
        list.add("C");
        list.add("E");
        list.add("D");
        list.add(30);

        System.out.println("초기상태 : ");
        System.out.println(list); // [A, B, C, D, 30]

        System.out.println("인덱스 1 위치에 B 추가 : ");
        list.add(1, "B"); // 인덱스 번호를 지정하고 추가하는 형태
        System.out.println(list); // [A, B, C, E, D]

        System.out.println("인덱스 2 위치의 값 삭제 : ");
        list.remove(2);
        System.out.println(list); // [A, B, E, D]

        System.out.println("인덱스 2번 위치의 값 반환 : " + list.get(2));  // E
    }
}
