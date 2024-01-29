package ch_09.memberTreeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class MemberTreeSet {
    private TreeSet<Member> treeSet; // treeSet 선언

    public MemberTreeSet() { treeSet = new TreeSet<>(); } // treeSet 생성

    public void addMember(Member member) { treeSet.add(member); }

    public boolean removeMember(int memberId) { // treeSet에서 회원 삭제
        Iterator<Member> ir = treeSet.iterator();

        while (ir.hasNext()) {
            Member member = ir.next();
            int tempId = member.getMemberId();
            if (tempId == memberId) {
                treeSet.remove(member);
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;
    }

    public void showAllMember() {
        for (Member member : treeSet) {
            System.out.println(member);
        }
        System.out.println();
    }
}
