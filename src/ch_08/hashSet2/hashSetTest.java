package ch_08.hashSet2;

import java.util.HashSet;
import java.util.Set;

public class hashSetTest {
    public static void main(String[] args) {
        Set<MemberShip> set = new HashSet<>();

        // 인스턴스는 다르지만 내부 데이터가 동일하므로 객체 1개만 저장
        MemberShip memberShip1 = new MemberShip("홍길동", 30);
        MemberShip memberShip2 = new MemberShip("홍길동", 30);

        set.add(memberShip1);
        set.add(memberShip2); // 저장되는 주소값이 같아 1개만 저장

        MemberShip memberShip3 = new MemberShip("홍길동", 31);
        set.add(memberShip3);

        System.out.println("총 객체수: " + set.size());
    }
}
