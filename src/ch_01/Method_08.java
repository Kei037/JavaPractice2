package ch_01;

import java.util.Scanner;

public class Method_08 {
    static void putStars(int a) {
        for (int i = 0; i < a; i++) {
            System.out.print("*");
        }
    }

    static void reStars(int a) {
        for (int i = a; i > 0; i--) {
            System.out.print("*");
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("좌하변이 직각인 직각삼각형을 표시합니다.");
        System.out.print("몇 단 : ");
        int n = stdIn.nextInt();

        for (int i = 1; i <= n; i++) {
           putStars(i);
           System.out.println("");
        }

        System.out.println("");

        for (int i = 1; i <= n; i++) {
            reStars(n);
            System.out.println("");
        }
    }
}
