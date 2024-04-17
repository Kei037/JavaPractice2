package ch_21_java_lang_package;

public class D_03 {
    public static void main(String[] args) {
        /* StringBuffer, StringBuilder
        내부에 변경가능한 final이 아닌 char[]를 변수로 가지고 있음
        두 클래스를 사용하여 문자열을 연결하면 기존에 사용하던 char[] 배열이 확장되므로 추가 메모리를 사용하지 않음.

        두 클래스의 차이는 여러 작업(스레드)이 동시에 문자열을 변경하려 할 때 문자열이 안전하게 변경되도록 보장해 주는가 그렇지 않은가의 차이
        StringBuffer 클래스는 문자열이 안전하게 변경되도록 보장하지만, StringBuilder 클래스는 보장되지 않음
        따로 스레드를 생성하는 멀티스레드 프로그램이 아니라면 StringBuilder 를 사용하는것이 실행 속도가 더 빠름
         */

        String javaStr = new String("java");
        System.out.println("처음 문자열 주소 값: "+ System.identityHashCode(javaStr)); // 처음 문자열 주소 값: 1175962212

        StringBuilder buffer = new StringBuilder(javaStr);
        System.out.println("연산 전 buffer 메모리 주소 :" + System.identityHashCode(buffer)); // 연산 전 buffer 메모리 주소 :798154996
        buffer.append(" and");
        buffer.append(" android");
        buffer.append(" programming is fun!!");
        System.out.println("연산 후 buffer 메모리 주소 :" + System.identityHashCode(buffer)); // 연산 후 buffer 메모리 주소 :798154996

        javaStr = buffer.toString(); // String 클래스로 반환
        System.out.println(javaStr); // java and android programming is fun!!
        System.out.println("새로 만들어진 JavaStr 문자열 주소 :" + System.identityHashCode(javaStr)); //새로 만들어진 JavaStr 문자열 주소 :681842940
    }
}
