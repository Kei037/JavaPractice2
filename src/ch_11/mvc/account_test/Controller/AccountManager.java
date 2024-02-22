package ch_11.mvc.account_test.Controller;

import ch_11.mvc.account_test.Model.DAO.AccountDAO;
import ch_11.mvc.account_test.Model.DTO.Account;
import ch_11.mvc.account_test.Model.DTO.AccountHistory;
import ch_11.mvc.account_test.Model.DTO.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager implements IAccountManager {

    private final Scanner stdIn;
    private final AccountDAO accountDAO;

    public AccountManager() {
        stdIn = new Scanner(System.in);
        accountDAO = new AccountDAO();
    }

    @Override
    public void addMember() {
        // 회원가입
        Member member = new Member();

        System.out.print("아이디: ");
        member.setId(stdIn.next());

        System.out.print("이름: ");
        member.setName(stdIn.next());

        System.out.print("나이: ");
        member.setAge(stdIn.nextInt());

        System.out.print("거주지: ");
        member.setAddr(stdIn.next());

        if (isMember(member.getId())) { // 아이디 중복체크
            System.out.println(member.getId() + "는 사용중인 아이디입니다.");
        } else {
            accountDAO.insertMember(member);
            System.out.println("회원 등록이 되었습니다.");
        }

    }

    @Override
    public void addAccount() {
        // 계좌 생성
        Account account = new Account();

        System.out.print("아이디: ");
        account.setId(stdIn.next());

        System.out.print("계좌종류: (1: 예금계좌, 2: 대출계좌): ");
        int accountType = stdIn.nextInt();
        if (accountType == 1) {
            account.setActype("Savings");
        } else if (accountType == 2) {
            account.setActype("Checking");
        }

        System.out.print("계좌번호: ");
        account.setAcnum(stdIn.next());

        System.out.print("잔액: ");
        account.setBalance(stdIn.nextDouble());

        if (accountType == 1) {
            System.out.print("이자율: ");
        } else if (accountType == 2) {
            System.out.print("수수료율: ");
        }
        account.setRate(stdIn.nextDouble());

        if (!isMember(account.getId())) { // 아이디가 중복체크
            System.out.println(account.getId() + "는 없는 아이디입니다.");
            return;
        }

        if (isAccount(account.getAcnum())) { // 계좌중복 체크
            System.out.println(account.getAcnum() + "는 사용중인 계좌번호입니다.");
        } else { // 중복계좌없음 생성가능
            if (isPart(account)) { // 계좌타입 중복체크 Saving, Checking 구분
                accountDAO.insertAccount(account);
                System.out.println("계좌 등록이 되었습니다.");
            } else {
                System.out.println(account.getActype());
                if (account.getActype().equals("Savings")) {
                    System.out.println("이미 예금계좌가 개설되어 있습니다.");
                } else if (account.getActype().equals("Checking")){
                    System.out.println("이미 대출계좌가 개설되어 있습니다.");
                }
            }
        }

    }

    @Override
    public void deposit() {
        // 입금 메소드
        System.out.print("계좌번호: ");
        String accountNumber = stdIn.next();

        System.out.print("입금액: ");
        double money = stdIn.nextDouble();

        Account account = accountDAO.selectAccount(accountNumber);
        AccountHistory acHistory = null;
        double insertMoney;

        if (isAccount(accountNumber)) { // 계좌가 존재
            if (account.getActype().equals("Savings")) {
                // DB account에 입금
                insertMoney = money + (money * account.getRate()) + account.getBalance();
                accountDAO.updateBalance(account.getAcnum(), insertMoney);

                // 입금 기록
                acHistory = new AccountHistory(accountNumber, "입금",
                        money, money + account.getBalance());
                accountDAO.insertAccountHistory(acHistory);

                // 예금이자 기록
                acHistory = new AccountHistory(accountNumber, "입금",
                        (money * account.getRate()), insertMoney);
                accountDAO.insertAccountHistory(acHistory);

            } else if (account.getActype().equals("Checking")) {
                // DB account에 입금
                insertMoney = money + account.getBalance();
                accountDAO.updateBalance(account.getAcnum(), insertMoney);

                // 입금 기록
                acHistory = new AccountHistory(accountNumber, "입금", money, insertMoney);
                accountDAO.insertAccountHistory(acHistory);
            }
        } else {
            System.out.println("해당 계좌번호가 존재하지 않습니다.");
        }
    }

    @Override
    public void withdraw() {
        // 출금 메소드
        System.out.print("계좌번호: ");
        String accountNumber = stdIn.next();

        System.out.print("출금액: ");
        double money = stdIn.nextDouble();

        Account account = accountDAO.selectAccount(accountNumber);
        AccountHistory acHistory = null;
        double insertMoney;

        if (!isAccount(accountNumber)) { // 해당 계좌 찾기
            System.out.println("해당 계좌번호가 존재하지 않습니다.");
            return;
        }
        if (account.getBalance() < money) {
            System.out.println("잔액이 부족합니다.");
            return;
        }

        if (account.getActype().equals("Savings")) {
            // DB account에 출금
            insertMoney = account.getBalance() - money;
            accountDAO.updateBalance(account.getAcnum(), insertMoney);

            // 출금기록
            acHistory = new AccountHistory(accountNumber, "출금", money, insertMoney);
            accountDAO.insertAccountHistory(acHistory);
        } else if (account.getActype().equals("Checking")) {
            // DB account에 출금 + 이자율출금
            insertMoney = account.getBalance() - (money * account.getRate()) - money;
            accountDAO.updateBalance(account.getAcnum(), insertMoney);

            // 출금 기록
            acHistory = new AccountHistory(accountNumber, "출금",
                    money, (account.getBalance() - money));
            accountDAO.insertAccountHistory(acHistory);
            // 이자율출금 기록
            acHistory = new AccountHistory(accountNumber, "출금",
                    (money * account.getRate()), insertMoney);
            accountDAO.insertAccountHistory(acHistory);
        }

    }

    @Override
    public void viewHistory() {
        // 잔액 및 거래내역 조회
        System.out.print("계좌번호: ");
        String accountNumber = stdIn.next();

        ArrayList<AccountHistory> list = accountDAO.selectAccountHistories(accountNumber);
        for (AccountHistory accountHistory : list) {
            System.out.println(accountHistory.toString());
        }
        double balance =  accountDAO.selectBalance(accountNumber);
        System.out.println("잔액: " + balance);
    }

    @Override
    public void disConnect() { // 종료
        accountDAO.disConnect();
        stdIn.close();
    }

    @Override
    public boolean isMember(String memberId) {
        return accountDAO.selectMemberIdCnt(memberId) == 1;
    }

    @Override
    public boolean isAccount(String accountId) {
        return accountDAO.selectAccountIdCnt(accountId) == 1;
    }

    @Override
    public boolean isPart(Account account) {
        // 중복계좌타입 체크
        ArrayList<Account> list = accountDAO.selectAccountType(account.getId());

        for (Account aList : list) {
            if (aList.getActype().equals(account.getActype())) {
                return false;
            }
            if (aList == null) {
                return true;
            }
        }
        return true;
    }
}
