package ch_11.mvc.Project1;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ===========================================================
 * fileName       : AccountManager
 * date           : 2024-02-20
 * description    : Controller 역할을 하는 클래스
 * ===========================================================
 */
public class AccountManager implements IAccountManager {

    private final Scanner stdIn;
    private final AccountDao accountDAO;
    private Member member = new Member();
    private Account account = new Account();
    private AccountHistory accountHistory = new AccountHistory();


    public AccountManager() {
        this.accountDAO = new AccountDao();  // AccountDAO 인스턴스 생성 // getConnection() 실행
        this.stdIn = new Scanner(System.in);
    }

    @Override
    public void addMember() { // choice : 1 일때
        System.out.print("아이디: ");    // 유저_아이디
        String userId = stdIn.next();
//        member.setUserId(stdIn.nextLine()); // test (문자열형식) // String
        System.out.print("이름: "); // 유저_이름
        String name = stdIn.next();
//        member.setName(stdIn.nextLine()); // 김유니    // String
        System.out.print("나이: "); // 유저_나이
        int age = stdIn.nextInt();
//        member.setAge(stdIn.nextInt()); // 25   // int
        System.out.print("거주지: "); // 유저_거주지
        String addr = stdIn.next();
//        member.setAddr(stdIn.nextLine()); // 경북 // String
        member = new Member(userId, name, age, addr);

        // 회원가입 시 아이디 중복 검사
        if (isMember(member.getUserId())) {
            // 회원 등록
            accountDAO.insertMember(member);
//           ㄴ INSERT INTO member (userId, name, age, addr) VALUES  ( 'test', '김유니', 25, '경북');
            // 이렇식으로
            System.out.println("회원 등록이 되었습니다.");
        } else { // 중복검사해서 중복이 나온 경우
            System.out.println(member.getUserId() + "는 사용중인 아이디입니다.");
        }

    }

    @Override
    public void addAccount() { // choice : 2 일 때 

        System.out.print("아이디: ");
        String userId = stdIn.next(); // 유저 아이디
        System.out.print("계좌종류: (1: 예금계좌, 2: 대출계좌): ");
        int type = stdIn.nextInt(); // 1 혹은 2만 입력 가능하도록 제약을 걸어두었음
        System.out.print("계좌번호: ");
        String accountid = stdIn.next();
        System.out.print("잔액: ");
        double balance = stdIn.nextDouble();
        double rate = 0.0;

        if (type == 1) {
            System.out.print("이자율: ");
        } else if (type == 2) { // tpye == 2
            System.out.print("수수료율: ");
        }                               // 1 , 1 , 12345, 10000, 1.0
        rate = stdIn.nextDouble();
        account = new Account(userId, type, accountid, balance, rate);

        if (!isMember(userId)) { // 새로 입력한 fpkm3033
            // 사용중인 계좌 번호인지
            if (isAccount(account.getAccountId())) { // 12345 - String 타입
                // 해당 아이디가 같은 계좌 종류를 사용 하는지
                if (isPart(account)) {  // 대출/예금 => true
                    if (type == 1) { // 예금계좌
                        System.out.println("Savings");
                        System.out.println("이미 계좌가 개설되어 있습니다.");
                    } else if (type == 2) { // 대출계좌
                        System.out.println("Checking");
                        System.out.println("이미 계좌가 개설되어 있습니다.");
                    }
                } else {
                    accountDAO.insertAccount(account);
                    System.out.println("계좌 등록이 되었습니다.");
                }
            } else {
                System.out.println(account.getAccountId() + "는 사용중인 계좌번호입니다.");
            }
        } else {
            System.out.println(userId + "는 없는아이디입니다.");

        }
    }

    @Override
    public void deposit() { // case 3번
        System.out.print("계좌번호: ");
        String accountNum = stdIn.next();

        System.out.print("입금액: ");
        double money = stdIn.nextDouble();

        account = accountDAO.selectAccount(accountNum); //account DB를 받아옴

        if (!isAccount(account.getAccountId())) {
            AccountHistory acHistory = null;

            if (account.getAccountType() == 1) {
                // true : 예금 계좌
                accountDAO.updateBalance(account.getAccountId(),account.getBalance() + money + (money * account.getTypeRate()));

                acHistory = new AccountHistory(1, money, account.getBalance() + money, accountNum);
                accountDAO.insertAccountHistory(acHistory);
                acHistory = new AccountHistory(1, account.getTypeRate() * money,
                        account.getBalance() + money + (account.getTypeRate() * money), accountNum);
                accountDAO.insertAccountHistory(acHistory);
            } else if (account.getAccountType() == 2){
                // false : 대출 계좌
                System.out.println("계좌원금: " + account.getBalance());
                System.out.println("입금액: " + money);
                accountDAO.updateBalance(account.getAccountId(), account.getBalance() + money);
                acHistory = new AccountHistory(1, money, account.getBalance() + money, accountNum);
                accountDAO.insertAccountHistory(acHistory);
            }

        } else {
            System.out.println("해당 계좌번호가 존재하지 않습니다.");
        }
    }

    @Override
    public void withdraw() { // case 4번 출금
        System.out.print("계좌번호: ");
        String accountNum = stdIn.next();

        System.out.print("출금액: ");
        double money = stdIn.nextDouble();

        account = accountDAO.selectAccount(accountNum); //account DB를 받아옴

        if (money > account.getBalance()){
            System.out.println("출금하려는 금액이 입금액 보다 큽니다.");
            return;
        }

        if (!isAccount(account.getAccountId())) {
            AccountHistory acHistory = null;
            if (account.getAccountType() == 1) {
                // true : 예금 계좌
                accountDAO.updateBalance(account.getAccountId(), account.getBalance() - money);
                acHistory = new AccountHistory(2, money, account.getBalance() - money, accountNum);
                accountDAO.insertAccountHistory(acHistory);
            } else if (account.getAccountType() == 2){
                // false : 대출 계좌                  // 'fpkm3033' 10000
                accountDAO.updateBalance(account.getAccountId(), account.getBalance() - money - (money * account.getTypeRate()));
                acHistory = new AccountHistory(2, money, account.getBalance() - money, accountNum);
                accountDAO.insertAccountHistory(acHistory);
                acHistory = new AccountHistory(2, money * account.getTypeRate(),
                        account.getBalance() - money - (money * account.getTypeRate()), accountNum);
                accountDAO.insertAccountHistory(acHistory);
            }
        } else {
            System.out.println("해당 계좌번호가 존재하지 않습니다.");
        }
    }

    @Override
    public void viewHistory() { // case 5번
        String type = "";

        System.out.print("계좌번호: ");
        account.setAccountId(stdIn.next()); //1234

        ArrayList<AccountHistory> list = accountDAO.selectAccountHistories(account.getAccountId());

        if (isAccount(account.getAccountId())) {
            System.out.println("계좌 번호를 잘못 입력하셨습니다.");
            return;
        }

        for (AccountHistory accountHistory1 : list) {
            if (accountHistory1.getTransactionType() == 1) {
                type = "입금";
            } else {
                type = "출금";
            }
            System.out.println(type + "\t" + accountHistory1.getAmount() + " \t" + accountHistory1.getBalanceAfter());
        }
        System.out.println("잔액 : " + accountDAO.selectBalance(account.getAccountId()));
    }

    @Override
    public void disConnect() { // case 6번
        accountDAO.disConnect();
        stdIn.close();
    }

    @Override
    public boolean isMember(String userId) { // 해당 아이디의 회원 개수를 반환
        if (accountDAO.selectMemberIdCnt(userId) == 0) {
            //   select count(*) from member where userId = 'test';
            return true;
        }
        return false;
    }

    @Override
    public boolean isAccount(String accountId) {    // 해당 계좌번호의 계좌 개수를 반환
        if (accountDAO.selectAccountIdCnt(accountId) == 0) {    // 0 : 해당 계좌 번호의 계좌가 없다.
            //select count(*) from account where accountId = '12345';
            return true;
        }
        return false;
    }

    @Override
    public boolean isPart(Account account) { // 계좌 유형 중복검사
        return accountDAO.selectIsAccountType(account); // DAO 클래스에서 만드는 편이 좋을듯 합니다.
        // 반환값이 1이면 예금 0이면 출금으로     // todo 틀리면 0
        /*
        // 이런식
       select accountType
       from account
       where memberid = (
       select memberId from member where userId = 'test'); # get으로 id 가져오기

       반환값이 true : 예금계좌
       반환값이 false : 출금계좌
         */
    }
}
