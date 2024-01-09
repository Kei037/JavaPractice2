package ch_01;

import java.util.Scanner;

public class Method_04 {
    /*
    밑변이 30, 높이가 10인 사각형의 넓이를 출력하세요.
    단 메서드 calculator()를 호출해서 출력하세요.
    결과값 :
    <계산을 시작합니다.
    밑변이 30, 높이가 10인 사각형의 넓이는 300입니다.
     */
    static int calculator(int a, int b) {
        System.out.println("<계산을 시자합니다.");
        int area = a * b;
        return area;
    }

    public static void main(String[] args) {
        System.out.println("밑변이 30, 높이가 10인 사각형의 넓이는 " + calculator(30, 10) + "입니다.");
    }
}
