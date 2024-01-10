package ch_01;

public class ExValue_02 {
    /*
    메서드 increase() 호출 시에 n이라는 매개변수가 메모리에 생성되어
    var1의 값인 100이 복사 되어 처리
    메서드 실행이 종료되면 매개변수 n은 메모리에서 소멸
    이 처럼 값에 의한 호출은 호출시 매개변수로 전달되는 값이 복사되어 전달.
    따라서 var1의 값은 변하지 않음
     */
    public static void increase(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i]++;
        }
    }
    
    public static void main(String[] args) {
        int[] refArray = {100, 800, 1000};

        System.out.println("메서드 호출 전");
        for (int i = 0; i < refArray.length; i++) {
            System.out.println("refArray[" + i + "]:" + refArray[i]);
        }

        increase(refArray);

        System.out.println();
        System.out.println("메서드 호출 후");
        // 배열은 참조형이라 메서드 호출 후 값이 변경

        for (int i = 0; i < refArray.length; i++) {
            System.out.println("refArray[" + i + "]:" + refArray[i]);
        }
    }
}
