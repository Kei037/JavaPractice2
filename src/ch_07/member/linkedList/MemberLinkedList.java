package ch_07.member.linkedList;

import ch_07.member.Member;
import java.util.LinkedList;

public class MemberLinkedList {
    private final LinkedList<Member> linkedList;

    public MemberLinkedList() {
        this.linkedList = new LinkedList<>();
    }

    public void addMember(Member member) {
        linkedList.add(member);
    }

    public boolean removeMember(int memberID) {
        for (int i = 0; i < linkedList.size(); i++) {
            Member member = linkedList.get(i);
            if (member.getMemberId() == memberID) { // 회원 아이디와 매개변수가 일치하면
                linkedList.remove(i); // 해당 회원을 삭제
                return true;
            }
        }
        System.out.println(memberID + "가 존재하지 않습니다."); // 반복문을 돌려서 해당 아이디를 찾지 못한 경우
        return false;
    }

    public void showAllMember() { // 전체 회원을 출력하는 메서드
        for (Member member : linkedList) {
            System.out.println(member);
        }
        System.out.println();
    }
}
