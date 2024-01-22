package ch_04.abstractTest6;

public class RegularMember extends Member {
    private String name;         // 회원의 이름
    private int membershipYear;  // 회원 가입 연차

    public RegularMember(String name, int i) {
        this.name = name;
        this.membershipYear = i;
    }

    @Override
    String getName() { return this.name; }

    @Override
    int calculateAnnualFee() {
        if (membershipYear < 4) {
            return 100;
        }else {
            return 80;
        }
    }
}
