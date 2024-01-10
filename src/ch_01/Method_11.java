package ch_01;

public class Method_11 {

    static int getMax(int a, int b) {
        return (a > b) ? a : b;
    }

    static int getMax(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    public static void main(String[] args) {
        int a, b, c;
        a = 10;
        b = 20;
        c = 30;
        System.out.println(a + ", " + b + ", " + c + " 중에 제일 큰수는 " + getMax(a, b, c) + "입니다.");
        System.out.println(a + ", " + b + " 중에 제일 큰수는 " + getMax(a, b) + "입니다.");
    }
}
