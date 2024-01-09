import java.util.Scanner;

public class Method_03 {
    static int getMax(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 a : ");
        int a = sc.nextInt();
        System.out.print("정수 b : ");
        int b = sc.nextInt();
        System.out.print("정수 c : ");
        int c = sc.nextInt();

        System.out.println("최대값은 " + getMax(a, b, c) + "입니다.");
        sc.close();
    }
}
