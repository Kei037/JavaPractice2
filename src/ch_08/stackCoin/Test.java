package ch_08.stackCoin;

import java.util.Stack;

class Coin {
    private int value;

    public Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class Test {
    public static void main(String[] args) {
        Stack<Coin> coinBox = new Stack<>();

        coinBox.push(new Coin(100));
        coinBox.push(new Coin(50));
        coinBox.push(new Coin(500));
        coinBox.push(new Coin(10));

        while (!(coinBox.size() == 0)) { // 동전 케이스가 비었는지 확인
            Coin coin = coinBox.pop(); // 동전 케이스에서 제일 위의 동저을 꺼냄
            System.out.println("꺼내온 동전: " + coin.getValue() + "원");
        }
        /*
        while (!coinBox.isEmpty()) {
            System.out.println("꺼내온 동전: " + coinBox.pop().getValue() + "원");
        }
         */
    }
}
