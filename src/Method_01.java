import java.util.Scanner;

public class Method_01 {
    static int getMax(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] height = new int[3];
        int[] weight = new int[3];
        int[] age = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("[" + (i + 1) + "] ");
            System.out.print("신장:");
            height[i] = sc.nextInt();
            System.out.print("    체중:");
            weight[i] = sc.nextInt();
            System.out.print("    나이:");
            age[i] = sc.nextInt();
        }

        int maxHeight = getMax(height[0], height[1], height[2]);
        int maxWeight = getMax(weight[0], weight[1], weight[2]);
        int maxAge = getMax(age[0], age[1], age[2]);

        System.out.println("신장의 최대값은 " + maxWeight + "입니다.");
        System.out.println("체중의 최대값은 " + maxWeight + "입니다.");
        System.out.println("나이의 최대값은 " + maxAge + "입니다.");

    }
}
