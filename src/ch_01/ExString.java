package ch_01;

public class ExString {

    public static String setAddress(String addr) {
        addr = "경기도 수원시 장안구";
        return addr;
    }
    public static void main(String[] args) {
        String address = "서울시 간암구 논현동";

        System.out.println("메서드 호출 전");
        System.out.println("address: " + address);

        address = setAddress(address);

        System.out.println("메서드 호출 후");
        System.out.println("address: " + address);
    }
}
