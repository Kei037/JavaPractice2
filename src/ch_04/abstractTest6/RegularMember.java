package ch_04.abstractTest6;

public class RegularMember extends Member {
    public RegularMember(String name, int membershipYear) {
        super(name, membershipYear);
    }

    @Override
    int calculateAnnualFee() {
        if (super.getMembershipYear() < 4) {
            return 100;
        }else {
            return 80;
        }
    }
}
