package ch_05.interfaceTest7;

interface Buy {
    void buy();
    void info();
}

interface Sell {
    void sell();
    void info();
}

class Customer implements Buy, Sell {
    @Override
    public void buy() {
        System.out.println("구매하기");
    }

    @Override
    public void sell() {
        System.out.println("판매하기");
    }
    // 두 인터페이스에 이름이 같은 메서드가 선언되었다고 해도 구현은 클래스에서 이루어 지므로,
    // 어떤 메서드를 호출해야 하는지 모호하지 않음

    @Override
    public void info() {
        System.out.println("Customer 입니다.");
    }
}

public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Buy buyer = customer;
        buyer.buy();

        Sell seller = (Sell)customer;
        seller.sell();
        if (seller instanceof Customer) {
            Customer customer2 = (Customer) seller;
            customer2.buy();;
            customer2.sell();
        }
    }
}
