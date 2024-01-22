package ch_04.abstractTest6;

public class RegularMember extends Member {

    public RegularMember(String name, int i) {
        this.name = name;
        this.membershipYear = i;
    }

    @Override
    int calculateAnnualFee() {
        if (membershipYear < 4) {
            return 100;
        }else {
            return 80;
        }
    }
}
