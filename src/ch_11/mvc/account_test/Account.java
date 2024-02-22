package ch_11.mvc.account_test;

public class Account {
    private String id;
    private String actype;
    private String acnum;
    private double balance;
    private double rate;

    public Account() {}

    public Account(String id, String actype, String acnum, double balance, double rate) {
        this.id = id;
        this.actype = actype;
        this.acnum = acnum;
        this.balance = balance;
        this.rate = rate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActype() {
        return actype;
    }

    public void setActype(String actype) {
        this.actype = actype;
    }

    public String getAcnum() {
        return acnum;
    }

    public void setAcnum(String acnum) {
        this.acnum = acnum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", actype='" + actype + '\'' +
                ", acnum='" + acnum + '\'' +
                ", balance=" + balance +
                ", rate=" + rate +
                '}';
    }
}
