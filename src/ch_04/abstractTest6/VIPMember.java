package ch_04.abstractTest6;

public class VIPMember extends Member{
    private String name;         // 회원의 이름
    private int membershipYear;  // 회원 가입 연차
    public VIPMember(String name, int i) {
        this.name = name;
        this.membershipYear = i;
    }

    @Override
    String getName() { return this.name; }

    @Override
    int calculateAnnualFee() {
        return 50;
    }
}
