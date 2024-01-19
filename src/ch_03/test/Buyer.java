package ch_03.test;

/* 수정
1) 구매한 물품을 저장하는 기능 추ㅏ
2) 구매한 물품에 대한 정보를 요약해서 보여주는 기능 추가
 */
public class Buyer {  // 고객, 물건을 사는사람
    int money = 1000; // 소유금액
    int bonusPoint = 0; // 보너스점수

    Product[] products = new Product[10];  // 구입한 제품을 저장하기위한 배열
    int i = 0; // Product배열에 사용될 카운터

    void buy(Product product) { // 부모 클래스 타입으로 매개변수 받음
        // 부모 클래스의 필드사용. price, bonusPoint
        if (money < product.price) {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }

        money -= product.price;             // 가진 돈에서 구입한 제품의 가격을 뺀다.
        bonusPoint += product.bonusPoint;   // 제품의 보너스 점수를 추가한다.
        products[i++] = product;            // 제품을 Product[] products에 저장
        System.out.println(product + "을/를 구입하셨습니다.");
    }

    void summary() {          // 구매한 물품에 대한 정보를 요약해서 보여준다
        int sum = 0;          // 구입한 물품의 가격합계
        String itemList = ""; // 구입한 물품목록

        // 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
        // 1) for 이용
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) { break; }
            itemList += products[i] + " ";
            sum += products[i].price;
        }
        // 2) foreach 이용 for(각 요소의 타입과 요소를 담을 변수 : 배열 또는 컬렉션)
        for (Product product : products) {
            if (product == null) { break; }
            itemList += product + " ";
            sum += product.price;
        }
        // 3) 반복을 줄이기 위해 인스턴스 변수 i 사용
        for (int i = 0; i < this.i; i++) {
            itemList += products[i] + " ";
            sum += products[i].price;
        }

        System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
        System.out.println("구입하신 제품은 " + itemList + "입니다.");
    }

    void refund(Product product) {
        for (int i = 0; i < this.i; i++) {
            if (products[i].equals(products.equals(product))) {
                System.out.println("테스트코드");
            }

            System.out.println(product);
        }
    }

    /*
    void refund(Product product) {
        if (products.remove(product)) {
            money += product.price;
            bonusPoint -= product.bonusPoint;
            System.out.println(product + "을/를 반품하셨습니다.");
        } else {
            System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
        }
    }
     */
}
