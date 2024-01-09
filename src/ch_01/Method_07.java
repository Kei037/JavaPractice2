package ch_01;

public class Method_07 {
    public int add(int a, int b) {
        int c = a + b;
        return c;
    }

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int reuslt = 0;

        Method_07 method = new Method_07();
        reuslt = method.add(num1, num2);
        System.out.println("두수의 합은 " + reuslt);
        System.out.println("두수의 합은 " + method.add(num1, num2));

    }
}
