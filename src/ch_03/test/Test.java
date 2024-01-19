package ch_03.test;

public class Test {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();

        buyer.buy(new Tv());
        buyer.buy(new Computer());
        buyer.buy(new Audio());

        buyer.summary();
        buyer.refund(new Tv());

    }
}
