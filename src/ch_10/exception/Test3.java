package ch_10.exception;

public class Test3 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};

        try {
            System.out.println("arr[2]=" + arr[2]);
            System.out.println("arr[3]=" + arr[3]);
            System.out.println("arr 출력 완료");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("예외 발생 : catch문 수행");
        }
        System.out.println("try/catch 구문 밖 문장 수행");
    }
}
