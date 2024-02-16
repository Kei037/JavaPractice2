package ch_11.builder;

public class Account {
    // 객체 생성 과정과 표현 방법을 분리하여 동일한 생성 절차에서 서로 다른 표현 결과르 얻을 수 있게
    // java에서 객체의 ㅊ초기화와 생성을 캡슐화 하는 데 유용하게 사용

    private int accID; // 객체 ID
    private int balance; // 잔액
    private String cusName; // 고객이름

    public Account(int accID, int balance, String cusName) {
        this.accID = accID;
        this.balance = balance;
        this.cusName = cusName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accID=" + accID +
                ", balance=" + balance +
                ", cusName='" + cusName + '\'' +
                '}';
    }

    public static class Builder {
        private int accID;
        private int balance;
        private String cusName;

        // 빈 생성자 객체 생성
        public Builder() {}

        // 체이닝 메서드 사용을 위해 객체 반환
        public Builder accID(int accID) {
            this.accID = accID;
            return this;
        }

        public Builder balance(int balance) {
            this.balance = balance;
            return this;
        }

        public Builder cusName(String cusName) {
            this.cusName = cusName;
            return this;
        }

        public Account build() { return new Account(this.accID, this.balance, this.cusName); }
    }
}
