package ch_05.interfaceTest8;

interface Buy {
    void buy();
    default void order() {
        System.out.println("구매 주문");
    };
}

interface Sell {
    void sell();
    default void order() {
        System.out.println("구매 주문");
    };
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

    // 디폴트 메서드가 중복이 되었으니 두 인터페이스를 구현하는 Customer 클래스에서 재정의 해야 함
    @Override
    public void order() {
        System.out.println("판매 주문 입니다.");
    }
}

public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Buy buyer = customer;
        buyer.buy();
        buyer.order();

        Sell seller = (Sell)customer;
        seller.sell();
        seller.order();
        if (seller instanceof Customer) {
            Customer customer2 = (Customer) seller;
            customer2.buy();;
            customer2.sell();
        }
    }
}
