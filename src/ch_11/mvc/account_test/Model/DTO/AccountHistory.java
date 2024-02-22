package ch_11.mvc.account_test.Model.DTO;

public class AccountHistory {
    private int no;
    private String acnum;
    private String transtype;
    private double amount;
    private double balance;

    public AccountHistory() {}

    public AccountHistory(String acnum, String transtype, double amount, double balance) {
        this.acnum = acnum;
        this.transtype = transtype;
        this.amount = amount;
        this.balance = balance;
    }

    public AccountHistory(int no, String acnum, String transtype, double amount, double balance) {
        this.no = no;
        this.acnum = acnum;
        this.transtype = transtype;
        this.amount = amount;
        this.balance = balance;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getAcnum() {
        return acnum;
    }

    public void setAcnum(String acnum) {
        this.acnum = acnum;
    }

    public String getTranstype() {
        return transtype;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return transtype + "\t" + amount + "\t" + balance;
    }
}
