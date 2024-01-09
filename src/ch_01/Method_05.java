package ch_01;

import java.util.Scanner;

public class Method_05 {
    /*
    밑변이 30, 높이가 10인 사각형의 넓이를 출력하세요.
    단 메서드 calculator()를 호출해서 출력하세요.
    결과값 :
    <계산을 시작합니다.
    밑변이 30, 높이가 10인 사각형의 넓이는 300입니다.
     */
    static int getMax(int a, int b) {
        System.out.println("함수 시작");
        if (a > b) {
            return a;
        }else {
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 a : ");
        int a = scanner.nextInt();
        System.out.print("정수 b : ");
        int b = scanner.nextInt();

        System.out.println("최대값은 " + getMax(a, b) + "입니다.");
        scanner.close();
    }
}
