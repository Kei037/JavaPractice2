package ch_04.abstractTest6;

abstract class Member {
    private String name;         // 회원의 이름
    private int membershipYear;  // 회원 가입 연차

    abstract int calculateAnnualFee();

    public Member(String name, int membershipYear) {
        this.name = name;
        this.membershipYear = membershipYear;
    }

    public String getName() { return name; }

    public int getMembershipYear() { return membershipYear; }

}
