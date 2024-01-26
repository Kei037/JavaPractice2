package ch_08.hashSet2;
/*
Member 객체를 중복 없이 저장하는 HashSet
hashCode()와 equals()메소드를 재정의 하지 않으면 저장된 객체가 2개
 */
public class MemberShip {
    // hashCode()와 equals() 재정의
    public String name;
    public int age;

    public MemberShip(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() { // name과 age값이 같으면 동일한 hashCode 반환
        return name.hashCode() + age; // String의 hashCode() 이용
    }

    @Override
    public boolean equals(Object obj) { // name과 age값이 같으면 true 리턴
        // name과 age값이 같으면 true 반환
        if (obj instanceof MemberShip) {
            MemberShip memberShip = (MemberShip) obj;
            return memberShip.name.equals(this.name) && (memberShip.age == age);
        }
        else {
            return false;
        }
    }
}
