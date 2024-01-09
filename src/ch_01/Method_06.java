package ch_01;

import java.util.Scanner;

public class Method_06 {
    public void print() {
        System.out.println("메서드를 호출한다.");
    }

    public static void main(String[] args) {
        Method_06 method = new Method_06();
        method.print();
        method.print();
        method.print();


    }
}
