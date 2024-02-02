package ch_10.exception2;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[10];

        try {
            for (int i = 0; i < 11; i++) {
                System.out.println(arr[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < 10; i++) {
            arr[i] = 1;
        }

    }
}
