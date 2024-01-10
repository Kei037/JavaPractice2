package ch_01;

import java.util.Random;
import java.util.Scanner;

public class Method_09 {
    static Scanner scanner = new Scanner(System.in);

    static boolean confirmRetry() {
        int cont;
        do {
            System.out.print("다시 한번? <Yes-1/No-0> : ");
            cont = scanner.nextInt();
        }while (cont != 0 && cont != 1);
        return cont == 1;  // cont가 1이면 true, 아니면 false
    }

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("암산 트레이닝!!");

        do {
            int x = random.nextInt(90) + 10;
            int y = random.nextInt(90) + 10;
            int z = random.nextInt(90) + 10;

            while (true) {
                System.out.println(x + " + " + y + " + " + z + " = ");
                int k = scanner.nextInt();
                if (k == x + y + z) {
                    break;
                }else if (k < x + y + z) {
                    System.out.println("UP!");
                }else {
                    System.out.println("DOWN!");
                }
                System.out.println("틀렸습니다.");
            }
        }while (confirmRetry());

    }
}
