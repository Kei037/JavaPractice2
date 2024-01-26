package ch_08.hashSet3;

import java.util.HashSet;

public class MemberHashSet {
    private HashSet<Member> hashSet; // hashSet 선언

    public MemberHashSet() {
        hashSet = new HashSet<>(); // hashSet 생성
    }

    public void addMember(Member member) {
        hashSet.add(member); // hashSet에 회원 추가
    }

    public boolean removeMember(int memberId) {
        // 매개변수로 받은 회원 아이디에 해당하는 회원 삭제
        for (Member member : hashSet) {
            int tempId = member.getMemberId(); // 아이디 비교
            if (tempId == memberId) { // 같은 아이디인 경우
                hashSet.remove(member); // 회원 삭제
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;
    }

    public void showAllMember() { // 모든 회원 출력
        for (Member member : hashSet) {
            System.out.println(member);
        }
        System.out.println();
    }

}
