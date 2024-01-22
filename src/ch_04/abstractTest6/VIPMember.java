package ch_04.abstractTest6;

public class VIPMember extends Member {
    public VIPMember(String name, int membershipYear) {
        super(name, membershipYear);
    }

    @Override
    int calculateAnnualFee() {
        return 50;
    }
}
