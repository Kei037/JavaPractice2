package ch_03.test2;

public class Test {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        Tv tv = new Tv();
        Computer com = new Computer();
        Audio audio = new Audio();

        b.buy(tv);
        b.buy(com);
        b.buy(audio);
        b.summary();

        System.out.println();

        b.refund(com);
        b.summary();

    }
}
