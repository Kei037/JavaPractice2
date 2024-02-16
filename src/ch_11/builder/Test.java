package ch_11.builder;

public class Test {
    public static void main(String[] args) {
        /* 객체 생성시에 일정하지 않은 여러개의 조합으로 객체를 생성할 경우
         많은 수의 생성자를 만들어야 함
         빌더패턴은 유연하게 일정하지 않은 초기값으로 객체를 생성할 수 있음 */

        // 계좌번호를 초기값으로 객체 생성
        Account account1 = new Account.Builder().accID(222).build();
        System.out.println(account1);

        // 계좌번호, 잔액을 초기값으로 객체 생성
        Account account2 = new Account.Builder().accID(222).balance(10000).build();
        System.out.println(account2);

        // 계좌번호, 잔액, 예금주를 초기값으로 객체 생성
        Account account3 = new Account.Builder().accID(222).balance(10000).cusName("홍길동").build();
        System.out.println(account3);

        // 잔액, 예금주를 초기값으로 객체 생성
        Account account4 = new Account.Builder().balance(10000).cusName("홍길동").build();
        System.out.println(account4);

        // 예금주를 초기값으로 객체 생성
        Account account5 = new Account.Builder().cusName("홍길동").build();
        System.out.println(account5);
    }
}
