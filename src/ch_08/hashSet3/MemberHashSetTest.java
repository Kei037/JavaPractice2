package ch_08.hashSet3;

public class MemberHashSetTest {
    public static void main(String[] args) {
        MemberHashSet memberHashSet = new MemberHashSet();

        // 새로운 회원 인스턴스 생성
        Member memberLee = new Member(1001, "이지원");
        Member memberSon = new Member(1002, "손민국");
        Member memberPark = new Member(1003, "박서원");

        // ArrayList에 회원 추가
        memberHashSet.addMember(memberLee);
        memberHashSet.addMember(memberSon);
        memberHashSet.addMember(memberPark);
        memberHashSet.showAllMember(); // 전체 회원 출력

        memberHashSet.addMember(memberLee); // 중복된 객체 저장
        memberHashSet.showAllMember(); // 중복된 객체는 저장되지 않음

        Member memberHong = new Member(1003, "홍길동"); // 1003아이디 중복 회원 추가
        memberHashSet.addMember(memberHong);
        memberHashSet.showAllMember();

        memberHashSet.removeMember(1002);
        memberHashSet.showAllMember();
    }
}
